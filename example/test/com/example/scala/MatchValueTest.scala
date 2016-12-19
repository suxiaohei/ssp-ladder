package com.example.scala

import org.specs2.mutable.Specification

/**
  * Created by suxin on 16-12-19.
  */
class MatchValueTest extends Specification {

  "MatchValueTest" should {
    "matchValue" in {

      val value:Any = 12

      value match {
        case Some(v) => println("test")
        case 11 => println(11)
        case 12 => println(12)
      }
      ok
    }
  }
}
