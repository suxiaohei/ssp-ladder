package com.akkaInAction.scala.routerDriver

import akka.actor.{Actor, ActorRef}

/**
  * Created by suxin on 16-11-29.
  */
class AlternatingRouter(processor1: ActorRef, processor2: ActorRef) extends Actor {

  var alternate = 1;

  def alternateProcessor() = {
    if (alternate == 1) {
      alternate = 2
      processor1
    } else {
      alternate = 1
      processor2
    }
  }

  def receive = {
    case message: Any =>
      val processor = alternateProcessor()
      println(s"ALternatingRouter : routing $message to ${processor.path.name}")
      processor ! message

      MessageRouterDriver.completedStep()
  }
}
