package com.ladder.scala.akka.actor

import akka.actor.{Actor, ActorSystem, Props}

import scala.concurrent.Future

/**
  * Created by suxin on 16-11-24.
  */
class HelloActor extends Actor{

  def receive = {
    case "hello" => println("你好")
    case _ => println("您是？")
  }
}

object Main extends App{
  val system = ActorSystem("HellowSystem")

  val helloActor  = system.actorOf(Props[HelloActor], name = "helloActor")

  helloActor ! "hello"
  helloActor ! "dongdong"
}
