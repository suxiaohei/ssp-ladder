package com.example.scala.seq

import org.specs2.mutable.Specification

/**
  * Created by suxin on 16-12-12.
  */
class ListOperaTest extends Specification {

  "ListOperaTest" should {
    "printList" in {
      val list = List(1,2,3,4,5,6,7)
      val b = list.mkString(",")
      println("==============="+ b)

      val seq = Seq(1,2,3,4,5,6,7)
      val c = seq.mkString(",")
      println("==============="+ c)
      ok
    }

  }
}
