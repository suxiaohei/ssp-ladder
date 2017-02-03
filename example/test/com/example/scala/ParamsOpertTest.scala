package com.example.scala

import org.specs2.mutable.Specification

/**
  * Created by suxin on 17-1-23.
  */
class ParamsOpertTest extends Specification {

  "ParamsOpertTest" should {
    "defaultParam" in {

      def test1(a: String = "a", b: String, c: String = "c") = {
        println(a)
        println(b)
        println(c)
      }

      def test2(a: String = "a", b: String) = {
        println(a)
        println(b)
      }

      def test3(b: String, a: String = "a") = {
        println(a)
        println(b)
      }

      def test4(a: String = "a", b: String = "b", c: String = "c") = {
        println(a)
        println(b)
        println(c)
      }

//      test1(c = "aaa", "sdfa", a = "cccc") /**compile error**/
//      test2("sdfa", a = "cccc") /**parameter is already specified**/
      test3("sdfa", a = "cccc")
      test4(b = "sdfa", a = "cccc")


      ok
    }

  }
}
