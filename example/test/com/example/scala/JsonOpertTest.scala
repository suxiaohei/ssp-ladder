package com.example.scala

import org.specs2.mutable.Specification
import spray.json.{JsArray, JsString, _}

/**
  * Created by suxin on 17-2-8.
  */
class JsonOpertTest extends Specification {

  "JsonOpertTest" should {
    "json" in {
      println(JsObject.empty)
      ok
    }

    "elements" in {
      //      val json = JsObject("code" -> JsNumber(200), "data" -> JsString("""[{test:1},{test:2}]""") )
      val json = JsObject("code" -> JsNumber(200), "data" -> JsArray(JsObject("test" -> JsString("test"), "test2" -> JsString("test2")), JsString("22")))
      //      println(json.compactPrint)
      json.getFields("data").map {
        case jsArray: JsArray => {
          jsArray.elements.map {
            case sub_v: JsObject =>
              val subFields = sub_v.fields
              (subFields("test"), subFields("test2")) match {
                case (test, test2) => println(s"test $test  test2 $test2")
                case _ => println("none")
              }
              None
            case _ => println("None")
          }
        }
        case _ => println("None")
      }
      ok
    }

    "json2" in {
      val str_list = List("1", "2", "3")
//      val request_body = JsObject("store_uids" -> JsArray(str_list.map { store_id =>
//        JsObject("store_uid" -> JsString(store_id))
//      }: _*))
      val request_body = JsObject("store_uids" -> JsArray(str_list.map { store_id =>
        JsString(store_id)
      }: _*))
      println(request_body)
      ok
    }
  }
}
