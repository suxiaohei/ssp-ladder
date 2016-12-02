package com.akkaInAction.scala.pTop

import akka.actor.Props
import com.akkaInAction.scala.common.CompletableApp

/**
  * Created by suxin on 16-11-29.
  */
class ActorC {

}

object ActorC extends CompletableApp(1){
  val actorB = system.actorOf(Props[ActorB],"actorB")

  actorB ! "goodbye , from Actor C"
  actorB ! "goodbye again, from Actor C"
}