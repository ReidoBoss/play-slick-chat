error id: file:///C:/Users/PC/Desktop/database_vauldex/slick-chat/app/models/users/UsersRepository.scala:[480..480) in Input.VirtualFile("file:///C:/Users/PC/Desktop/database_vauldex/slick-chat/app/models/users/UsersRepository.scala", "package models.user
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.{Future,ExecutionContext}



class UsersTable(tag: Tag) extends Table[Users](tag,"users"){
    def id = column[Int]("id",O.PrimaryKey, O.AutoInc);
    def username = column[String]("username");
    def password = column[String]("password");

    def * = (id,username,password).mapTo[Users]
}

val users = TableQuery[UsersTable]; 

val db = Database.forConfig("chat_db");

def 
")
file:///C:/Users/PC/Desktop/database_vauldex/slick-chat/app/models/users/UsersRepository.scala
file:///C:/Users/PC/Desktop/database_vauldex/slick-chat/app/models/users/UsersRepository.scala:20: error: expected identifier; obtained eof

^
#### Short summary: 

expected identifier; obtained eof