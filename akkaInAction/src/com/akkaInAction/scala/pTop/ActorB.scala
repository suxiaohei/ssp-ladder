package com.akkaInAction.scala.pTop

import akka.actor.Actor

/**
  * Created by suxin on 16-11-29.
  */
class ActorB extends Actor {

  var hello = 0
  var helloAgain = 0
  var goodbye = 0
  var goodbyeAgain = 0

  def receive = {
    case message: String =>
      hello = hello + (if (message.contains("hello")) 1 else 0)
      helloAgain = helloAgain + (if (message.startsWith("hello again")) 1 else 0)
      assert(hello > helloAgain)

      goodbye = goodbye + (if (message.contains("hello")) 1 else 0)
      goodbyeAgain = goodbyeAgain + (if (message.startsWith("hello again")) 1 else 0)
      assert(goodbye > goodbyeAgain)
  }

}
