package com.akkaInAction.scala.pipeAndFilter

import akka.actor.{Actor, ActorRef}
import com.akkaInAction.scala.common.ProcessIncomingOrder

/**
  * Created by suxin on 16-11-29.
  */
class OrderAcceptanceEndpoint(nextFilter: ActorRef) extends Actor {

  def receive = {
    case rawOrder: Array[Byte] =>
      val text = new String(rawOrder)
      println(s"OrderAcceptanceEndpoint : Processing $text")
      nextFilter ! ProcessIncomingOrder(rawOrder)
      PipesAndFiltersDriver.completedStep()
  }

}
