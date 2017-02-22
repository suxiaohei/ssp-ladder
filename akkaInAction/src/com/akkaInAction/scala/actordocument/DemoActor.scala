package com.akkaInAction.scala.actordocument

import akka.actor.{Actor, Props}
import akka.event.Logging

/**
  * Created by suxin on 17-2-14.
  */
object DemoActor {

  def props(magicNumber: Long): Props = Props(new DemoActor(magicNumber))
}

class DemoActor(magicNumber:  Long) extends Actor {
  override def receive: Receive = {
    case x: Int => sender() ! (x + magicNumber)
  }
}

class SomeOtherActor extends Actor {
  val logger = Logging(context.system, this)
  val actor_child = context.actorOf(DemoActor.props(222L), "actor_child")

  override def receive: Receive = {
    case x: Int => actor_child ! x
    case x: Long => logger.info(x.toString)
  }
}
