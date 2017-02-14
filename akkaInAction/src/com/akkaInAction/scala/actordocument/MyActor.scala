package com.akkaInAction.scala.actordocument

import akka.actor.{Actor, ActorLogging}

/**
  * Created by suxin on 17-2-14.
  */
class MyActor extends Actor with ActorLogging{
  import MyActor._

  override def receive: Receive = {
    case Greeting(greeter) => log.info(s"i am $greeter")
    case Goodbye => log.info("bye bye")
  }
}

object MyActor {
  case class Greeting(from: String)
  case object Goodbye
}
