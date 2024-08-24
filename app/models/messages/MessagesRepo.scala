package models.messages
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.{Future,ExecutionContext}

class MessagesTable(tag:Tag) extends Table[Messages](tag,"messages"){
    def id = column[Int]("id",O.PrimaryKey,O.AutoInc);
    def sender = column[String]("sender");
    def receiver = column[String]("receiver");
    def content = column[String]("content");
    def * = (sender,receiver,content,id).mapTo[Messages]
}
val messages = TableQuery[MessagesTable]

val db = Database.forConfig("chat_db");

def getReceiver(receiver:String)={
    val query = (messages.filter(_.receiver===receiver))
    db.run(query.result)
}
def getSender(sender:String)={
    val query = (messages.filter(_.sender===sender))
    db.run(query.result)
}

def getChat(sender:String,receiver:String)={
    val query = messages
    .filter(msg => 
        (msg.sender === sender && msg.receiver === receiver) ||
        (msg.sender === receiver && msg.receiver === sender)
        )
    db.run(query.result)
}

def sendChat(sender:String,receiver:String,content:String)={
    val query = messages += Messages(sender,receiver,content) 
    db.run(query)
}