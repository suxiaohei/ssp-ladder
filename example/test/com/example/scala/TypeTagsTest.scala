package com.example.scala

import org.specs2.mutable.Specification

import scala.reflect.ClassTag

/**
  * Created by suxin on 17-2-3.
  */
class TypeTagsTest extends Specification {

  "TypeTagsTest" should {
    "defineTypeTag" in {

      import scala.reflect.api.TypeTags
      val t = TypeTag[List[String]]
      ok
    }

    "defineClassTag" in {

      import scala.reflect.classTag
      val c = ClassTag[Int]
      println(c)

      import scala.reflect.runtime.universe._
      val tt = typeTag[Int]

      ok
    }

  }
}
