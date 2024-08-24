package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import scala.concurrent.{ExecutionContext,Future}
import models.user.{getUser,getAllUsersExceptCurrent}
@Singleton
class LandingPageController @Inject()(val controllerComponents: ControllerComponents)(using ec: ExecutionContext) extends BaseController {

  

  def index() = Action.async{ request=> 
    val user_id = request.session.get("user_id")
    user_id match {
      case Some(id) => getUser(id.toInt).flatMap{
        user => 
          getAllUsersExceptCurrent(id.toInt).map{
            allUser => 
              Ok(views.html.home(allUser.toList,user(0).username))
          }
        }
      case _ => Future(Redirect("/").flashing("message" -> "Please Login First")) 
    }

  }


  
}
