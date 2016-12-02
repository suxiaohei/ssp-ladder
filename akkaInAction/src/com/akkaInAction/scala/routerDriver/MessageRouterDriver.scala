package com.akkaInAction.scala.routerDriver

import akka.actor.Props
import com.akkaInAction.scala.common.CompletableApp

/**
  * Created by suxin on 16-11-29.
  */
object MessageRouterDriver extends CompletableApp(20) {
  val processor1 = system.actorOf(Props[Processor], "proessor1")
  val processor2 = system.actorOf(Props[Processor], "proessor2")

  val alternatingRouter = system.actorOf(Props(classOf[AlternatingRouter], processor1, processor2), "alternatingRouter")

  for (count <- 1 to 10) {
    alternatingRouter ! "Message#" + count
  }

  awaitCompletion()

  println("MessageRouter : is completerd.")
}
