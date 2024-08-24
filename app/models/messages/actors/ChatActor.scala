package actors

import org.apache.pekko.actor.{Actor,Props,ActorRef}

class ChatActor(out:ActorRef,manager:ActorRef) extends Actor{
    import ChatActor._
    manager ! ChatMananger.NewChatter(self)
    def receive = {
        case s:String => manager ! ChatMananger.Message(s)
        case SendMessage(msg) => out ! msg
        case m:Any => println("Unhandled message in Chat Actor" + m)
    }
}

object ChatActor{
    def props(out:ActorRef,manager:ActorRef) = Props(new ChatActor(out,manager))

    case class SendMessage(msg:String) 
}