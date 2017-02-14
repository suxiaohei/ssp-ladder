package com.akkaInAction.scala.actordocument

import akka.actor.{ActorSystem, Props}
import org.specs2.mutable.Specification

/**
  * Created by suxin on 17-2-14.
  */
class SomeOtherActorTest extends Specification {

  "SomeOtherActorTest" should {
    "postStop" in {

      val system = ActorSystem("mySystem")
      val actor_test = system.actorOf(Props[SomeOtherActor], "actor_test")
      actor_test ! 2
      ok
    }
  }
}
