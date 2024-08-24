package models.usersAuth
import slick.jdbc.PostgresProfile.api._
// import slick.profile.SqlProfile.ColumnOption.SqlType
import slick.sql.SqlProfile.ColumnOption.SqlType
import scala.concurrent.{Future,ExecutionContext}
import java.sql.Timestamp

val now = System.currentTimeMillis();

class UsersAuthTable(tag:Tag) extends Table[UsersAuth](tag,"users_auth"){
	def id = column[Int]("id_users");
	def isSuccess = column[Boolean]("is_success");
	// def timestamp = column[String]("timestamp",O.Default);
	// def timestamp = column[Timestamp]("timestamp", SqlType("timestamp not null default CURRENT_TIMESTAMP"))
	def timestamp = column[Timestamp]("timestamp")

	def * = (isSuccess,id,timestamp).mapTo[UsersAuth]
}

val db = Database.forConfig("chat_db")

val usersAuth = TableQuery[UsersAuthTable]

def insertAuth (id:Int,isSuccess:Boolean) = {
	val query:DBIO[Option[Int]] = usersAuth ++= Seq(UsersAuth(isSuccess,id))

	db.run(query)
}