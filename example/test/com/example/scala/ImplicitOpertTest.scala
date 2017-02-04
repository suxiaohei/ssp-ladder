package com.example.scala

import org.specs2.mutable.Specification

/**
  * Created by suxin on 17-2-4.
  */
class ImplicitOpertTest extends Specification {

  "ImplicitOpertTest" should {
    "defineImplicit" in {

      implicit val a = 2

      def test(implicit i:Int) = {
        println(i)
      }

      test
      test(1)

      ok
    }

  }
}
