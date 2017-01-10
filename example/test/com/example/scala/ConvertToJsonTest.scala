package com.example.scala

import org.specs2.mutable.Specification

/**
  * Created by suxin on 17-1-5.
  */
class ConvertToJsonTest extends Specification {

  "ConvertToJsonTest" should {
    "converToJson" in {
      import spray.json._

      val jsonStr = JsObject("name" -> JsString("test"), "age" -> JsNull)
      println(jsonStr.compactPrint)
      ok
    }

  }
}
