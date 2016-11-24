package com.ladder.scala.akka.actor

import akka.actor.Actor
import akka.event.Logging


class ActorTest extends Actor{
  val log = Logging(context.system, this)

  def receive  = {
    case "test" => log.info("received test")
    case _ => log.info("receive unknow msg")
  }
}
