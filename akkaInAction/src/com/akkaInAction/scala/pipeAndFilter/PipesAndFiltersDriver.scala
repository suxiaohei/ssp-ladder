package com.akkaInAction.scala.pipeAndFilter

import akka.actor.Props
import com.akkaInAction.scala.common.CompletableApp

/**
  * Created by suxin on 16-11-29.
  */
object PipesAndFiltersDriver extends CompletableApp(9) {

  val orderText = "(encryption)(certificate)<order id='123'>...</order>"

  val rawOrderBytes = orderText.toCharArray.map(_.toByte)

  val filter5 = system.actorOf(Props[OrderMessagementSystem], name = "orderManagementSystem")
  val filter4 = system.actorOf(Props(classOf[Deduplicator], filter5), name = "deduplicator")
  val filter3 = system.actorOf(Props(classOf[Authenticator], filter4), name = "authenticator")
  val filter2 = system.actorOf(Props(classOf[Decrypter], filter3), name = "decrypter")
  val filter1 = system.actorOf(Props(classOf[OrderAcceptanceEndpoint], filter2), name = "orderAcceptanceEndpoint")

  filter1 ! rawOrderBytes
  filter1 ! rawOrderBytes

  awaitCompletion()
  println("PipesAndFiltersDriver : is completed.")
}
