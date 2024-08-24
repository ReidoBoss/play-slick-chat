package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import scala.concurrent.{Future,ExecutionContext}
import models.user._

@Singleton
class UserController @Inject()(val controllerComponents: ControllerComponents)(using ec:ExecutionContext) extends BaseController {

  def index() = Action { implicit request: Request[AnyContent] =>
    val req = request.session.get("user_id")
    req match {
      case Some(a) => Redirect("/landing")
      case None => Ok(views.html.index())
    }
    
  }

  
  def register() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.register())
  }

  def get() = Action(parse.json).async{
    request => 
      val username = (request.body \ "username").as[String];
      val password = (request.body \ "password").as[String];      

      val action = successAuth(username,password).map{
        user=> 
          if(user.length==1)
            models.usersAuth.insertAuth(user(0).id,true)
            Ok(Json.parse("""{"Message": "Success!"}""")).withSession("user_id" -> user(0).id.toString)
          else 
            failAuth(username).map{
              user => 
                if(user.length == 1)
                  models.usersAuth.insertAuth(user(0).id,false)

            }
            NotFound(Json.parse("""{"Message": "NotFound"}"""))         
      }
      action
  }

  // def addBook: Action[JsValue] = Action(parse.json) { request =>
  //   request.body.validate[Book].map { book =>
  //     books = books :+ book
  //     Created(Json.toJson(book))
  //   }.getOrElse(BadRequest("Invalid book format"))
  // }

  def insert()= Action(parse.json).async{
    request => 
      val username = (request.body \ "username").as[String];
      val password = (request.body \ "password").as[String];
      insertUser(username,password).map{
        user=> Created(Json.toJson(user))
      }
  }
  def logout()= Action{
    Redirect("/").withNewSession
  }


  
}
