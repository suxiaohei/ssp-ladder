package com.example.scala

import org.specs2.mutable.Specification
import play.api.Logger

import scala.async.Async.async
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.Success

/**
  * Created by suxin on 16-12-1.
  */
class AsyncAndAwaitTest extends Specification {
  "ApplyAndUnapplyTest" should {
    "main" in {
      import scala.async.Async.async
      import scala.concurrent.Future
      for (a <- 1 to 3) {
        async {
          println("第一次 ： " + a)
          scala.async.Async.await(Future {
            println("等待完成 " + a)
          })
          scala.async.Async.await(Future {
            println("已经完成 " + a)
          })
          async {
            println("第二层 ： " + a)
          }
        }
      }
      ok
    }

    "async In List" in {

      val list = List(1, 2, 3, 4, 5, 6, 7)
      val newList = list.map { i =>
        async {
          if (i % 2 == 0) {
            Future.successful(i)
          } else {
            Future.failed(new RuntimeException("is false"))
          }
        }
      }

      val t = Future.sequence(newList).map { list =>
        list.foreach { result =>
          result onComplete {
            case Success(msg) =>
            //              println(msg)
            case scala.util.Failure(e) =>
            //              Logger.error("错误信息! ", e)
          }
        }
        Future.successful("继续")
      }.flatMap(x => x)

      val newT = t andThen {
        case v => Future.failed(new RuntimeException("is false"))
      } andThen {
        case Success(msg) =>
          println("完美结束 " + msg)
          Future.failed(new RuntimeException("is false"))
        case scala.util.Failure(e) =>
          println("出现了问题")
      }

      newT onComplete {
        case Success(msg) =>
          println("完美结束 " + msg)
        case scala.util.Failure(e) =>
          Future.failed(new RuntimeException("最后的问题"))
      }

      t onComplete {
        case Success(msg) =>
          println("完美结束 " + msg)
        case scala.util.Failure(e) =>
          Future.failed(new RuntimeException("最后的问题"))
      }
      //      newList map println
      ok
    }

    "async In List 2" in {

      val list = List(1, 2, 3, 4, 5, 6, 7)
      val newList = list.map { i =>
        async {
          if (i % 2 == 0) {
            Future.successful(i)
          } else {
            Future.failed(new RuntimeException("is false"))
          }
        }
      }

      val t = Future.sequence(newList).map { list =>
        list.foreach { result =>
          result onComplete {
            case Success(msg) =>
              println(msg)
            case scala.util.Failure(e) =>
              Logger.error("错误信息! ", e)
          }
        }
        Future.successful("继续")
      }.flatMap(x => x)

      val t2 = async {
        Future.failed(new RuntimeException("验证异常是否发生"))
      }

      val newT = t fallbackTo t2

//      val b = Await.result(newT, Duration(10000, "millis"))
      newT onComplete {
        case Success(msg) => println(msg + "==============================")
        case scala.util.Failure(e) => Logger.error("最后的错误信息! ", e)
      }

      ok
    }

    "future onComplete" in {
      import scala.async.Async.async
      import scala.concurrent.Future
      val list = List(1, 2, 3)
      //      Future.traverse(list) { i=>
      list.map { i =>
        val firFuture = async {
          if (i % 2 == 0) {
            Future.successful(true)
          } else {
            Future.failed(new RuntimeException("can not operator"))
          }
        }

        firFuture onComplete {
          case Success(msg) => println(msg)
          case scala.util.Failure(e) => Logger.error("错误信息! ", e)
        }
      }
      ok
    }

    "list traver future onComplete" in {
      import scala.async.Async.async
      import scala.concurrent.Future
      val list = List(1, 2, 3)
      //      Future.traverse(list) { i=>
      val listFuture = Future.traverse(list) { i =>
        val result = async {
          if (i % 2 == 0) {
            println(i)
            Future.successful(true)
            Future.failed(new RuntimeException("can not operator"))
          } else {
            println(i)
            Thread.sleep(5000000)
            Future.failed(new RuntimeException("can not operator"))
          }
        }
        result
      }.flatMap(x => Future.sequence(x))

      listFuture onComplete {
        case Success(msg) => println(msg)
        case scala.util.Failure(e) => Logger.error("错误信息! ", e)
      }

      //      listFuture.flatMap { list =>
      //        async{
      ////          list map println
      //        }
      //      }
      ok
    }
  }
}
