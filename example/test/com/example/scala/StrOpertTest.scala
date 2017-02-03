package com.example.scala

import org.specs2.mutable.Specification

/**
  * Created by suxin on 17-1-23.
  */
class StrOpertTest extends Specification {

  "StrOpertTest" should {
    "megerStr1" in {
      val str =
        """testaaaaabbbb
          |cadfasdfasdfas
        """.stripMargin
      println(str)
      ok
    }
  }

  "StrOpertTest" should {
    "megerStr2" in {
      val str =
        """testaaaaabbbb""" +
          """ cadfasdfasdfas """
      println(str)
      ok
    }
  }
}
