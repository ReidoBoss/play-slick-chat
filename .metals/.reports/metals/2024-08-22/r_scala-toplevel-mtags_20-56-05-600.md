error id: file:///C:/Users/PC/Desktop/database_vauldex/slick-chat/app/models/messages/MessagesRepo.scala:[244..247) in Input.VirtualFile("file:///C:/Users/PC/Desktop/database_vauldex/slick-chat/app/models/messages/MessagesRepo.scala", "package models.messages
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.{Future,ExecutionContext}

class MessagesTable(tag:Tag) extends Table[Messages]{
    def id = column[Int]("id",O.PrimaryKey,O.AutoInc);
    def 
    def * = ().mapTo[Messages]
}")
file:///C:/Users/PC/Desktop/database_vauldex/slick-chat/app/models/messages/MessagesRepo.scala
file:///C:/Users/PC/Desktop/database_vauldex/slick-chat/app/models/messages/MessagesRepo.scala:8: error: expected identifier; obtained def
    def * = ().mapTo[Messages]
    ^
#### Short summary: 

expected identifier; obtained def