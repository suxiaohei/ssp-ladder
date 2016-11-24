package com.ladder.scala.akka.props

import akka.actor.Props
import com.ladder.scala.akka.actor.{ActorTest, ActorWithArgs}

/**
  * Created by suxin on 16-11-24.
  */
class PorpsTest {

  val prop1 = Props[ActorTest]
  val prop2 = Props(new ActorWithArgs("sx"))
  val prop3 = Props(classOf[ActorWithArgs], "sx")

}
