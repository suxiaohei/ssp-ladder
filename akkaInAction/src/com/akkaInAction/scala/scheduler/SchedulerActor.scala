package com.akkaInAction.scala.scheduler

import akka.actor.Actor

/**
  * Created by suxin on 16-12-2.
  */
class SchedulerActor extends Actor{

  override def receive = {
    case Some(a) => println(s" input is $a")
    case str:String =>  println(s" input is $str")
    case _ => println(new java.util.Date() + "=======================================================")
  }

}
