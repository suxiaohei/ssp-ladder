package com.example.scala

import org.specs2.mutable.Specification
import play.Logger

import scala.concurrent.Future
import scala.async.Async._
import scala.concurrent.ExecutionContext.Implicits.global

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
      ) yield d
      ok
    }

    "future.sequence" in {

      //测试Future的转换
      val listOfFutures = List.fill(10) {
        val fm = Future {
          100
        }.mapTo[Int]
        fm
      }
      //      val listOfFutures: List[Future[Int]] = Nil
      val futureList = Future.sequence(listOfFutures)
      //异步执行
      futureList.map { s =>
        val sum = s.sum
        println("List sum = " + sum)
        sum
      }
      val seqOfFutures = Seq(Future {
        111
      }.mapTo[Int], Future(22).mapTo[Int])
      val futureSeq = Future.sequence(seqOfFutures)
      futureSeq.map { s =>
        val sum = s.sum
        println("SeqSum = " + sum)
        sum
      }
      println("是否异步")
      ok
    }

    "future.traverse" in {

      val listInt1 = List(1, 2, 3, 4, 5, 5)
      val t1 = Future.traverse(listInt1) { v =>
        Future {
          v
        }
      }
      t1.map { v =>
        v map println
      }
      //
      //      val listInt = List.fill(2)(1, 2, 3, 4, 5, 5)
      //
      //      //Seq转换为Future
      //      val futureList = Future.traverse(listInt) { a =>
      //        Future {
      //          new String("" + a)
      //        }.mapTo[String]
      //      }
      //      futureList.map { a =>
      //        val c = a.map { b =>
      //          println(b)
      //          1
      //        }
      //        c.map { d => println(d) }
      //      }
      ok
    }

    "future pr" in {
      Future {
        println("Hello" + "World")
      }

      Future {
        println("Hello" + "World" + "=============")
      }
      ok
    }

    "future.map" in {
      val f1 = Future {
        "Hello" + "World"
      }
      val f2 = f1 map { x =>
        x.length
      }
      f2 foreach println
      ok
    }

    "future.foreach" in {
      val future = Future {
        Future.failed(new RuntimeException(s"failed when OssAliyunGallery.Get_Url_Info(${11}) !"))
        //        None.get
      }

      val future1 = Future {
        "Hello " + "World" + "=================="
      }

      future onFailure {
        case msg => println("失败"); println(msg)
      }

      future onSuccess {
        case msg => println("成功"); println(msg + "======================================")
      }

      //      future1 onSuccess {
      //        case msg => println(msg)
      //      }
      future foreach println
      //      future1 foreach println
      ok
    }

    "asynctest" in {

      val result = async {

        FutureOpert.throwE

        if (true) {
          scala.async.Async.await {
            println(1)
            Future(1)
          }
          scala.async.Async.await {
            println(2)
            Future(2)
          }
          scala.async.Async.await {
            println(3)
            Future(3)
          }
          scala.async.Async.await {
            Future.failed(new RuntimeException("test1111"))
          }
        }
      }

      result onComplete {
        case scala.util.Success(msg) => println("Success " + msg)
        case scala.util.Failure(e) => println("Failure " + e)
      }
      ok
    }

    "asynctest2" in {

      val result = async {
        val te = scala.async.Async.await {
          val fuList = Future[List[Int]](
            List[Int](1, 2, 2, 3, 4)
          )
          fuList.flatMap {
            case l if l.head == 2 => Future.successful(l.head)
            case _ => Future.failed(new RuntimeException("test1111"))
          }
        }
        te
      }
      result onComplete {
        case scala.util.Success(msg) => println(msg)
        case scala.util.Failure(e) => println(e)
      }
      ok
    }

    "asynctest3" in {
      val result = async {
        val result2 = async {
          val te = scala.async.Async.await {
            val fuList = Future[List[Int]](
              List[Int](1, 2, 2, 3, 4)
            )
            fuList.flatMap {
              case l if l.head == 2 => Future.successful(l.head)
              case _ => Future.failed(new RuntimeException("test1111"))
            }
          }
          te
        }
        result2 onComplete {
          case scala.util.Success(msg) => println("success2 " + msg)
          case scala.util.Failure(e) =>
            println("result2 " + e)
            404
        }
      }
      result onComplete {
        case scala.util.Success(msg) => println("success1 " + msg)
        case scala.util.Failure(e) => println("result1 " + e)
      }
      ok
    }

    "asynctest4" in {

      val list = List(1, 2, 3, 4, 5)
      val list2 = List(6, 7, 2, 8, 1, 9, 10)

      list.map { va =>
        val list3 = Future.traverse(list2) {
//          case v if v != va => Future(v + " test")
//          case _ => Future.failed(new RuntimeException("excepiton"))
                    v =>
                      Future.failed(new RuntimeException("excepiton"))
        }

        list3 onComplete {
          case scala.util.Success(msg) => print(msg + " ")
          case scala.util.Failure(e) => Logger.error("failed when get list", e)
        }
      }
      ok
    }

    "asynctest5" in {


      val result = async {
        val list2 = List(6, 7, 2, 8, 1, 9, 10)
        val result1 =  Future.traverse(list2) { v =>
          val result2 =  async {
            scala.async.Async.await(Future(println(1 + " " + v)))
            scala.async.Async.await(Future(println(2 + " " + v)))
            scala.async.Async.await(Future(println(31)))
            Future.failed(new RuntimeException("excepiton"))
            scala.async.Async.await(Future(println(4)))
          }
          result2
        }
        result1 onComplete {
          case scala.util.Success(msg) =>
          case scala.util.Failure(e) => Logger.error("failed when get list", e)
        }
      }

//      result onComplete {
//        case scala.util.Success(msg) => print(msg + " ")
//        case scala.util.Failure(e) => Logger.error("failed when get list", e)
//      }
      ok
    }
  }

}
