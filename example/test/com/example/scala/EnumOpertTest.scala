package com.example.scala

import org.specs2.mutable.Specification

/**
  * Created by suxin on 17-2-3.
  */
class EnumOpertTest extends Specification {

  "EnumOpertTest" should {
    "defindEnum" in {

      object WeekDay extends Enumeration{
        type WeekDay = Value
        val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
      }

      import WeekDay._

      def isWorkingDay(d: WeekDay) = !(d == Sat || d == Sun)

      println(WeekDay.Sat.id)

//      WeekDay.values filter isWorkingDay foreach println

      ok
    }

  }
}
