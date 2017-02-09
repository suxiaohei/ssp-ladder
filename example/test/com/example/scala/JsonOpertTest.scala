package com.example.scala

import org.specs2.mutable.Specification
import spray.json.JsObject

/**
  * Created by suxin on 17-2-8.
  */
class JsonOpertTest extends Specification {

  "JsonOpertTest" should {
    "json" in {

      println(JsObject.empty)

      ok
    }

  }
}
