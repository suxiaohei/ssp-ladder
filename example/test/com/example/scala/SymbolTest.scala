package com.example.scala

import org.specs2.mutable.Specification

/**
  * Created by suxin on 16-12-2.
  */
class SymbolTest extends Specification {

  "SymbolTest" should {
    "persion_model" in {
      val p = new Symbol
      val jsObj =
        p.persion_model
      ok
    }

    "main" in {
      val p = Persion("2", "3", 2, 2)
      val p1 = new Persion1("2", "2", 2, 2)

      p match {
        case Persion(id, name, age, phone) => println(s"Persion is $id $name")
      }
      ok
    }

    "ne" in {
      println(1 == 1)
      ok
    }
  }
}
