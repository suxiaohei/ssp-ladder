package com.akkaInAction.scala.actorP

import akka.actor._


/**
  * Created by suxin on 16-11-28.
  */
class HelloActor extends Actor {

  val child = context.actorOf(Props[HelloActor], "helloActor-child")

  override def receive = {
    case "hello" => println("world"); //  child ! "hello"  实现重复引用，但每次actor都是上一级的子actor
    case _ => println("Who ? ")
  }

}

object HelloActor extends App {

  val system = ActorSystem("HelloSystem")
  val helloActor = system.actorOf(Props[HelloActor], name = "HelloActor")

  helloActor ! "hello"

}
