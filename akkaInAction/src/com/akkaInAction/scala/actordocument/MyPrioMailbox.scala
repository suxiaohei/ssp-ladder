package com.akkaInAction.scala.actordocument

import akka.actor.{Actor, ActorSystem, PoisonPill}
import akka.dispatch.{PriorityGenerator, UnboundedStablePriorityMailbox}
import akka.event.{Logging, LoggingAdapter}
import com.typesafe.config.Config

/**
  * Created by suxin on 17-2-14.
  */
class MyPrioMailbox(settings: ActorSystem.Settings, config: Config)
  extends UnboundedStablePriorityMailbox(
    PriorityGenerator {
      case 'highpriority => 0
      case 'lowpriority => 2
      case PoisonPill => 3
      case otherwise => 1
    }
  )

class Logger extends Actor {
  val log: LoggingAdapter = Logging(context.system, this)

  def receive = {
    case x => log.info(x.toString)
  }
}

