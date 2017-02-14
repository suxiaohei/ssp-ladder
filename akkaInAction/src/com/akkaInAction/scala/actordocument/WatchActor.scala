package com.akkaInAction.scala.actordocument

import akka.actor.{Actor, Kill, Props, Terminated}
import com.akkaInAction.scala.actordocument.MyActor.Goodbye

/**
  * Created by suxin on 17-2-14.
  */
class WatchActor extends Actor {

  val child = context.actorOf(Props.empty, "child")
  val myActor = context.actorOf(Props[MyActor], "myActor")
  context.watch(child)

  var lastSender = context.system.deadLetters

  override def receive: Receive = {
    case "kill" => {
      context.stop(child)
      lastSender = sender()
      println("================================================")
    }
    case Terminated(`child`) => {
      println("++++++++++++++++++++++++++++++++++++++++++++++++")
      lastSender ! "FINISHED"
      val actor_my = context.actorSelection("/user/actor_test/myActor")
      val actor_my1 = context.actorSelection("../myActor")
      myActor ! Goodbye
      actor_my ! Goodbye
      actor_my1 ! Goodbye
      actor_my1 ! Kill
    }
  }
}
