package com.example.scala

import org.specs2.mutable.Specification

/**
  * Created by suxin on 16-11-30.
  */
class ApplyAndUnapplyTest extends Specification {

  "ApplyAndUnapplyTest" should {
    "unapply" in {
      val ap = new ApplyAndUnapply
      ap.unapply(ap).get.toList.map(println(_))
      ok
    }

    "apply" in {
      ok
    }

    "main" in {
      val tu = List(List(1, None, 3), Tuple3(1, None, 6), 3, 5, "Sx")
      tu.map {
        case a: Int => println("Int is " + a)
        case a: String => println("String is " + a)
        case a: (Any, Any, Any) => println(a)
        case a: List[_] => a.map{ b => println(b); b}
        case _ => println("未知的类型")
      }
      ok
    }
  }
}
