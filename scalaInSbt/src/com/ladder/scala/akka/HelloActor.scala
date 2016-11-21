package com.ladder.scala.akka

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala

class HelloActor extends Actor {
  def receive = {
    case "hello" => println("您好！")
    case _       => println("您是?")
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem")
  // 缺省的Actor构造函数
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
  helloActor ! "hello"
  helloActor ! "喂"
}