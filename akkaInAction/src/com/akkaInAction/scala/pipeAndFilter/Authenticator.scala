package com.akkaInAction.scala.pipeAndFilter

import akka.actor.{Actor, ActorRef}
import com.akkaInAction.scala.common.ProcessIncomingOrder

/**
  * Created by suxin on 16-11-29.
  */
class Authenticator(nextFilter: ActorRef) extends Actor {

  def receive = {
    case message: ProcessIncomingOrder =>
      val text = new String(message.orderInfo)
      println(s"Authenticator : processing $text")

      val orderText = text.replace("(certificate)", "")
      nextFilter ! ProcessIncomingOrder(orderText.toCharArray.map(_.toByte))
      PipesAndFiltersDriver.completedStep()
  }

}
