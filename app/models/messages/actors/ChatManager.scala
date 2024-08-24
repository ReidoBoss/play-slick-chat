package actors

import org.apache.pekko.actor.{Actor,Props,ActorRef}

class ChatMananger extends Actor{
    import ChatMananger._
    private var chatters = List.empty[ActorRef]
    def receive = {
        case NewChatter(chatter) => chatters ::= chatter
        case Message(msg) => for (c <- chatters) c ! ChatActor.SendMessage(msg)
        case m:Any => println("Unhandled message in Chat Manager" + m)
    }
}

object ChatMananger{
    case class NewChatter(chatter:ActorRef)
    case class Message(msg:String)
}