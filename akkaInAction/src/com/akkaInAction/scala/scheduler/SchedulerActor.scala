package com.akkaInAction.scala.scheduler

import akka.actor.Actor

/**
  * Created by suxin on 16-12-2.
  */
class SchedulerActor extends Actor{

  override def receive = {
    case _ => println(new java.util.Date() + "=======================================================")
  }

}
