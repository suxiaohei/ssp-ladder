package com.akkaInAction.scala.pipeAndFilter

import akka.actor.Actor
import com.akkaInAction.scala.common.ProcessIncomingOrder

/**
  * Created by suxin on 16-11-29.
  */
class OrderMessagementSystem extends Actor {

  def receive = {
    case message: ProcessIncomingOrder =>
      val text = new String(message.orderInfo)

      println(s"OrderMangementSystem : Processing unique order:$text")

      PipesAndFiltersDriver.completedStep()
  }
}
