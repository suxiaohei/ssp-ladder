package com.example.scala

import org.specs2.mutable.Specification

/**
  * Created by suxin on 17-2-6.
  */
class MiscOpertTest extends Specification {

  "MiscOpertTest" should {
    "funOverLoad" in {
      println(MiscOpert().overload("1111").isInstanceOf[String])
      ok
    }

  }
}
