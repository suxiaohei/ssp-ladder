package com.akkaInAction.scala.actorP

import akka.actor.{Actor, ActorSystem, Props, Terminated}

/**
  * Created by suxin on 16-11-28.
  */
class WatchActor extends Actor {

  private var child: akka.actor.ActorRef = _

  override def preStart(): Unit = {
    child = context.actorOf(Props.empty, "child")
    context.watch(child)
  }

  def receive = {

    case "kill" => context.stop(child);
    case _ => println("no selected ")
  }

}

object WatchActor extends App {

  val system = ActorSystem("WatchActor")
  val watchActor = system.actorOf(Props[WatchActor], "watchActor")
  watchActor ! "kill"
}