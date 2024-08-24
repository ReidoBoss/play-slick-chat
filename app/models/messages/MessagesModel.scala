package models.messages
import play.api.libs.json._

case class Messages(
    sender:String,
    receiver:String,
    content:String,
    id:Int = 0
);

object Messages:
    given Format[Messages] = Json.format[Messages]