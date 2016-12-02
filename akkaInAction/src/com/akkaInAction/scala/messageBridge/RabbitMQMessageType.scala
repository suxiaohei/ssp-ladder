package com.akkaInAction.scala.messageBridge

/**
  * Created by suxin on 16-11-29.
  */
object RabbitMQMessageType extends Enumeration {
  type RabbitMQMessageType = Value
  val Binary, Text = Value
}

import RabbitMQMessageType._

case class RabbitMQBridgeConfig(messageTypes: Array[String], settings: RabbitMQConnectionSettings, name: String,
                                messageType: RabbitMQMessageType, durable: Boolean, exclusive: Boolean, autoAcknowledged: Boolean,
                                autoDeleted: Boolean) {
  if (messageTypes == null) throw new IllegalArgumentException("Must provide empty messageTypes.")
  if (settings == null) throw new IllegalArgumentException("Must provide settings.")
  if (name == null) throw new IllegalArgumentException("Must provide name.")
}

case class RabbitMQConnectionSettings(hostName: String, port: Int, virtualHost: String, userName: String, password: String) {

  def this() = this("localhost", -1, "/", null, null)

  def this(hostName: String, virtualHost: String) =
    this(hostName, -1, virtualHost, null, null)

  def hasPort(): Boolean = port > 0

  def hasUserCredentials(): Boolean = userName != null && password != null
}

case class RabbitMQBinaryMessage(messageType: String, messageId: String, timestamp: java.util.Date, binaryMessage: Array[Byte],
                                 deliveryTag: Long, redelivery: Boolean)

case class RabbitMQTextMessage(messageType: String, messageId: String, timestap: java.util.Date, textMessage: String, deliveryTag: Long,
                               redelivery: Boolean)