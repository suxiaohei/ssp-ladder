package com.akkaInAction.scala.pipeAndFilter

import akka.actor.{Actor, ActorRef}
import com.akkaInAction.scala.common.ProcessIncomingOrder

/**
  * Created by suxin on 16-11-29.
  */
class Deduplicator(nextFilter: ActorRef) extends Actor {

  val processOrderIds = scala.collection.mutable.Set[String]()

  def orderIdFrom(orderText: String): String = {
    val orderIndex = orderText.indexOf("id='") + 4
    val orderIdLastIndex = orderText.indexOf("'", orderIndex)
    orderText.substring(orderIndex, orderIdLastIndex)
  }

  def receive = {
    case message:ProcessIncomingOrder =>
      val text = new String(message.orderInfo)
      println(s"Deduplicator : processing $text")
      val orderId = orderIdFrom(text)

      if(processOrderIds.add(orderId)) {
        nextFilter ! message
      }else{
        println(s"Deduplicator : found duplicate order $orderId")
      }
      PipesAndFiltersDriver.completedStep()
  }
}



