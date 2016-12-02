package com.akkaInAction.scala.actorP

import java.util.concurrent.TimeUnit

import akka.actor.{Actor}
import akka.util.Timeout

import scala.concurrent.{ExecutionContext}


final case class Result(x: Int, s: String, d: Double)

case object Request

/**
  * Created by suxin on 16-11-28.
  */
class TellOrAskActor extends Actor {

  implicit val timeout = Timeout(5, TimeUnit.SECONDS)
  implicit val ec: ExecutionContext = context.dispatcher

  override def receive = {
    case Request => println("is Request")
    case _ => println("is no select")
  }
}
