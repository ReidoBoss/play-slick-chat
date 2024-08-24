error id: file:///C:/Users/PC/Desktop/database_vauldex/slick-chat/app/models/users/UsersRepository.scala:[484..487) in Input.VirtualFile("file:///C:/Users/PC/Desktop/database_vauldex/slick-chat/app/models/users/UsersRepository.scala", "package models.user
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.{Future,ExecutionContext}



class UsersTable(tag: Tag) extends Table[Users](tag,"users"){
    def id = column[Int]("id",O.PrimaryKey, O.AutoInc);
    def username = column[String]("username");
    def password = column[String]("password");

    def * = (username,password,id).mapTo[Users]
}

val users = TableQuery[UsersTable]; 

val db = Database.forConfig("chat_db");


def 

def insertUser(username:String,password:String):Future[Option[Int]]=
    val insert:DBIO[Option[Int]] = users ++= Seq (Users(username,password))
    db.run(insert) 

")
file:///C:/Users/PC/Desktop/database_vauldex/slick-chat/app/models/users/UsersRepository.scala
file:///C:/Users/PC/Desktop/database_vauldex/slick-chat/app/models/users/UsersRepository.scala:22: error: expected identifier; obtained def
def insertUser(username:String,password:String):Future[Option[Int]]=
^
#### Short summary: 

expected identifier; obtained def