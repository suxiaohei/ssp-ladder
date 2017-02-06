package com.example.scala

import org.specs2.mutable.Specification

/**
  * Created by suxin on 16-11-30.
  */
class ApplyAndUnapplyTest extends Specification {

  "ApplyAndUnapplyTest" should {
    "unapply" in {
      val str = "aa bb cc dd"
      str match {
        //自动调用ApplyAndUnapply的unapply方法
        case ApplyAndUnapply(n) => println(s"$str out put is $n")
        case _ => println("None")
      }
      ok
    }

    "apply" in {
      val newAp = new ApplyAndUnapply
      newAp()
      val ap = ApplyAndUnapply()
      println(ap)
      ok
    }

    "main" in {
      val tu = List(List(1, None, 3), Tuple3(1, None, 6), 3, 5, "Sx")
      tu.map {
        case a: Int => println("Int is " + a)
        case a: String => println("String is " + a)
        case a: (Any, Any, Any) => println(a)
        case a: List[_] => a.map { b => println(b); b }
        case _ => println("未知的类型")
      }
      ok
    }
  }
}
