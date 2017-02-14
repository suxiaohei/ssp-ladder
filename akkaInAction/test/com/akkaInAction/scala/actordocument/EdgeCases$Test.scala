package com.akkaInAction.scala.actordocument

import akka.actor.{ActorSystem, Props}
import com.akkaInAction.scala.actordocument.EdgeCases._
import org.specs2.mutable.Specification

/**
  * Created by suxin on 17-2-14.
  */
class EdgeCases$Test extends Specification {

  "EdgeCases$Test" should {
    "defaultValueProp1" in {

      val system = ActorSystem("mySystem")
      //      val defaultValueClass1 = Props[DefaultValueClass1]
      //      val defaultValueClass2 = Props(classOf[DefaultValueClass1])
      //      val defaultValueProp1 = Props(classOf[DefaultValueClass], 2.0)

      val valueClassProp = Props(classOf[ValueActor], MyValueClass(5))
      val testActor = system.actorOf(valueClassProp, "testActor")
      //      val testActor2 = system.actorOf(defaultValueClass1, "testActor2")
      //      val testActor3 = system.actorOf(defaultValueClass1, "testActor3")

      testActor ! 11L
      ok
    }

  }
}
