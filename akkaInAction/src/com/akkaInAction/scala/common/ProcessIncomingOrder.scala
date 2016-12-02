package com.akkaInAction.scala.common

case class ProcessIncomingOrder(rawOrder: Array[Byte]) {

  val orderInfo = rawOrder

}

/**
  * Created by suxin on 16-11-29.
  */
object ProcessIncomingOrder {

}
