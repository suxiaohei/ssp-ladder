package com.akkaInAction.scala.pTop

import akka.actor.Props
import com.akkaInAction.scala.common.CompletableApp

/**
  * Created by suxin on 16-11-29.
  */
class ActorA {

}

object ActorA extends CompletableApp(1) {
  val actorB = system.actorOf(Props[ActorB],"actorB")

  actorB ! "hello , from Actor A"
  actorB ! "hello again, from Actor A"

}
