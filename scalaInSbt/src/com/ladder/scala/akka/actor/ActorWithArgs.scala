package com.ladder.scala.akka.actor

import akka.actor.Actor
import akka.event.Logging

/**
  * Created by suxin on 16-11-24.
  */
class ActorWithArgs extends Actor {
  val log = Logging(context.system, this)

  private var age = 0
  private var name = ""

  def this(name: String) {
    this()
    this.name = name
  }

  def this(name: String, age: Int) {
    this(name)
    this.age = age
  }

  def receive  = {
    case _ => log.info("AcorWithArgs test")
  }
}
