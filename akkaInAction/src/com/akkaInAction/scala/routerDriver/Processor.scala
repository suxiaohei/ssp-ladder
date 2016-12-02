package com.akkaInAction.scala.routerDriver

import akka.actor.Actor

/**
  * Created by suxin on 16-11-29.
  */
class Processor extends Actor{

  def receive = {
    case message:Any =>
      println(s"Process : ${self.path.name} received $message")

      MessageRouterDriver.completedStep()
  }
}
