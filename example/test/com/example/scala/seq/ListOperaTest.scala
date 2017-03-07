package com.example.scala.seq

import org.specs2.mutable.Specification
import spray.client.pipelining._

/**
  * Created by suxin on 16-12-12.
  */
class ListOperaTest extends Specification {

  val list = List(1, 2, 3, 4, 5)
  val list_tupe2 = List((1, 1), (2, 2), (3, 3))

  "ListOperaTest" should {
    "printList" in {
      val b = list.mkString(",")
      println("===============" + b)

      val seq = Vector("1", "2", "3", "4", "5", "6", "aaaa")
      println(seq.mkString)
      println(seq.mkString(","))
      println(seq.mkString("\'", "\',\'", "\'"))
      ok
    }
    "foreachAndMap" in {

      val list2 = list foreach (2 *)
      val list3 = list map (2 *)
      list3.flatMap(List(_))
      list map println
      list3 map println
      ok
    }
    "headAndHeadOpt" in {
      val list = Nil
      //      list.head
      list.headOption
      ok
    }
    "find" in {
      list.find { i =>
        if (i == 0) true
        else false
      }
      ok
    }
    "collect" in {
      def colFun: PartialFunction[Any, Any] = {
        case i: Int => i
      }
      list.collect(colFun)
      ok
    }
    "take" in {
      println(list.take(2))
      println(list.tail(2))
      ok
    }
    "view" in {
      val viewP = list.view
      viewP map println
      ok
    }
    "range" in {
      println(1 to 15 by 4)
      ok
    }
    "currentPar" in {
      val list1 = list.par.map { i =>
        println(i)
        2 * i
      }
      println(list1)
      ok
    }
    "-> ::" in {
      val list1 = Nil
      val test = 'test -> 1 :: list1
      println(test)
      println(list1)
      ok
    }
    "toMap" in {
      println(list_tupe2.toMap)
      ok
    }

    "filter" in {

      val boolean_list = List(true, false, true)
      println(!boolean_list.filter(!_).headOption.isDefined)
      ok
    }
  }
}
