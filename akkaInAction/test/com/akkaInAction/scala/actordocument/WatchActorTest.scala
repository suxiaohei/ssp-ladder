package com.akkaInAction.scala.actordocument

import akka.actor.{ActorSystem, Props}
import org.specs2.mutable.Specification

/**
  * Created by suxin on 17-2-14.
  */
class WatchActorTest extends Specification {

  "WatchActorTest" should {
    "lastSender" in {
      val system = ActorSystem("mySystem")
      val actor_test = system.actorOf(Props[WatchActor], "actor_test")
      actor_test ! "kill"
      ok
    }

  }
}
