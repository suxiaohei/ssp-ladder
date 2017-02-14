package com.akkaInAction.scala.actordocument

import akka.actor.{Actor, Props}
import akka.event.Logging

/**
  * Created by suxin on 17-2-14.
  */
object EdgeCases {

  case class MyValueClass(v: Int) extends AnyRef

  class ValueActor(value: MyValueClass) extends Actor {

    val log = Logging(context.system, this)

    override def receive: Receive = {
      case multiplier: Long => sender() ! (value.v * multiplier)
      case _ => log.info("params is error")
    }
  }

//  java.lang.IllegalArgumentException
//  class DefaultValueClass(a: Int, b: Int = 5) extends Actor {
//    override def receive: Receive = {
//      case x: Int => sender() ! ((a + x) * b)
//    }
//  }

//  java.lang.IllegalArgumentException
//  class DefaultValueClass1(b: Int = 5) extends Actor {
//    override def receive: Receive = {
//      case x: Int => sender() ! (x * b)
//    }
//  }
}
