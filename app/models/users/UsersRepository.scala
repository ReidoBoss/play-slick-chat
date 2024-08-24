package models.user
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.{Future,ExecutionContext}
import play.api.libs.json._

class UsersTable(tag: Tag) extends Table[Users](tag,"users"){
    def id = column[Int]("id",O.PrimaryKey, O.AutoInc);
    def username = column[String]("username");
    def password = column[String]("password");

    def * = (username,password,id).mapTo[Users]
}

val users = TableQuery[UsersTable]; 

val db = Database.forConfig("chat_db");

def successAuth(username:String,password:String) = {
    val query = users.filter(user=> user.username===username && user.password === password).result
    db.run(query)
}

def failAuth(username:String)={
    val query = users.filter(user=> user.username===username).result
    db.run(query)
}

def getUser(id: Int) = {
    val query = users.filter(_.id === id)
    db.run(query.result)
}

def getUser(username: String) = {
    val query = users.filter(_.username === username)
    db.run(query.result)
}



def getAllUsersExceptCurrent(id:Int) = {
    val query = users.filterNot(_.id === id)
    db.run(query.result)
}





def getUserAuth = {
    val query = for {
        (usr,auth) <- users join models.usersAuth.usersAuth on (_.id===_.id)
    } yield (usr,auth)
    db.run(query.result)
}

def insertUser(username:String,password:String):Future[Option[Int]]=
    val insert:DBIO[Option[Int]] = users ++= Seq (Users(username,password))
    db.run(insert) 

