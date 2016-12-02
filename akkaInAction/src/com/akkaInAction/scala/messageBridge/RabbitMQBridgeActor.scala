package com.akkaInAction.scala.messageBridge

import akka.actor.Actor

/**
  * Created by suxin on 16-11-29.
  */
abstract class RabbitMQBridgeActor(config: RabbitMQBridgeConfig) extends Actor {

//    private val queueChannel = new QueueChannel(self,config)

  def receive = {
    case message: RabbitMQBinaryMessage =>
    case message: RabbitMQTextMessage =>
    case invalid: Any =>
  }
}
