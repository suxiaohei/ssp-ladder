package com.akkaInAction.scala.actordocument

import akka.actor.{ActorSystem, Props}
import org.specs2.mutable.Specification

/**
  * Created by suxin on 17-2-14.
  */
class MyPrioMailboxTest extends Specification {

  "MyPrioMailboxTest$Test" should {
    "test" in {
      val system = ActorSystem("mySystem")
      val actor_test = system.actorOf(Props[Logger], "actor_test")
      actor_test ! 'highpriority
      actor_test ! 'lowpriority
      actor_test ! 'bigdog
      actor_test ! 'bigdog2
      actor_test ! 'bigdog3
      actor_test ! 'highpriority
      actor_test ! 'PoisonPill

      ok
    }
  }
}
