package models.user
import play.api.libs.json.{Json,Format,Writes}
case class Users(
    username:String,
    password:String,
    id:Int = 0
)

object Users:
    // given Format[Users] = Json.format[Users]

    given Writes[Users] = new Writes[Users] {
      def writes(user: Users) = 
        Json.obj("id" -> user.id,
                 "username"  -> user.username
                 )
    }    

