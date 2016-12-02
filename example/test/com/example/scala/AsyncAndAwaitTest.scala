package com.example.scala

import org.specs2.mutable.Specification


/**
  * Created by suxin on 16-12-1.
  */
class AsyncAndAwaitTest extends Specification {
  "ApplyAndUnapplyTest" should {
    "main" in {
      import scala.async.Async.async
      import scala.concurrent.Future

      implicit val ec = play.api.libs.concurrent.Execution.Implicits.defaultContext

      for (a <- 1 to 3) {
        async {
          println("第一次 ： " + a)
          scala.async.Async.await(Future {
            println("等待完成")
          })
          scala.async.Async.await(Future {
            println("已经完成")
          })
          async {
            println("第二层 ： " + a)
          }
        }
      }
      ok
    }
  }
}
