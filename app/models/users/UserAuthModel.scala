package models.usersAuth
import play.api.libs.json._
import java.time.LocalDateTime
import java.sql.Timestamp

case class UsersAuth(
	is_success:Boolean,
	id_users:Int,
	timestamp: Timestamp = Timestamp(now)
);

