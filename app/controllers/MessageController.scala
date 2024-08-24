package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import scala.concurrent.{ExecutionContext,Future}
import models.user.{getUser}
import models.messages.{getChat,sendChat}
//chat imports
import org.apache.pekko.actor.{Actor,ActorSystem,Props}
import play.api.libs.streams.ActorFlow
import org.apache.pekko.stream.{Materializer}
import actors._

@Singleton
class MessageController @Inject()(val controllerComponents: ControllerComponents)(using ec: ExecutionContext,system:ActorSystem, mat:Materializer) extends BaseController {

  
    val manager = system.actorOf(Props(new ChatMananger),"Manager")

    def socket = WebSocket.accept[String,String]{ request =>
            ActorFlow.actorRef { out => 
            ChatActor.props(out,manager)
        }
    }

  def index(username:String) = Action.async{ implicit request: Request[AnyContent] => 
    val session = request.session.get("user_id")
    session match {
        case Some(id) =>
            getUser(session.get.toInt).flatMap{user=> 
                if(user(0).username==username){
                    Future(BadRequest("You cant chat with yourself"))
                }
                else{
                    getUser(username).flatMap{
                    user=> 
                    if(user.length==0) Future(NotFound("User Not Found"))
                    else 
                        getChat(user(0).username,username)
                        .map{chat => Ok(views.html.chat(user(0).username,username,chat))}
                    }

                }
            } 
        case None => Future(Redirect("/").flashing("message" -> "Please Login First"))
    }
  }

  def sendMessage(receiver:String)= Action(parse.json).async{ request => 
    val sender = request.session.get("user_id")
    val content = (request.body \ "content").as[String]
    sender match {
        case Some(user) => 
            getUser(user.toInt).flatMap{user=>
            sendChat(user(0).username,receiver,content)
            Future(Ok)
        }
        case _ => 
            Future(BadRequest)  
    }
  }






  
}
