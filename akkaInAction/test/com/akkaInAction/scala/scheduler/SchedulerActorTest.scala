package com.akkaInAction.scala.scheduler

import akka.actor.{ActorSystem, Props}
import org.specs2.mutable.Specification
import scala.concurrent.duration._

/**
  * Created by suxin on 16-12-2.
  */
class SchedulerActorTest extends Specification {

  "SchedulerActorTest" should {
    "main" in {

      implicit val ec = play.api.libs.concurrent.Execution.Implicits.defaultContext

      val system = ActorSystem("SchedulerActorTest")
      val schedulerActor = system.actorOf(Props[SchedulerActor], "schedulerActor")
      //五秒后执行
      system.scheduler.scheduleOnce(5 second, schedulerActor, "a")
      //一秒后执行，每秒执行一次
      system.scheduler.schedule(1 second, 1 second, schedulerActor, "b")
      //系统休眠10秒
      Thread.sleep(10000)
      ok
    }
  }

}
