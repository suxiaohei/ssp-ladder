package com.example.scala

import org.specs2.mutable.Specification

import scala.concurrent.Future

/**
  * Created by suxin on 16-12-1.
  */
class FutureOpertTest extends Specification {

  "FutureOpertTest" should {
    "main" in {

      implicit val ec = play.api.libs.concurrent.Execution.Implicits.defaultContext

      for (
        a <- Future {
          println("a")
        };
        b <- Future {
          println("b")
        };
        c <- Future {
          println("c")
        };
        d <- Future {
          println("d")
        }
      ) yield {
        val list = Future.sequence (
          List(a, b, c, d)
        )
      }
      ok
    }
  }
}
