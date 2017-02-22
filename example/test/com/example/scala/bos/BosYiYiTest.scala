package com.example.scala.bos

import org.specs2.mutable.Specification
import collection.JavaConversions._

/**
  * Created by suxin on 17-2-16.
  */
class BosYiYiTest extends Specification {

  "BosYiYiTest" should {
    "getClient" in {
      println("==============================================")
      println(BosYiYi.getClient.getBosAccountOwner)
      println("==============================================")
      ok
    }

    "getBucketList" in {
      println("==============================================")
      val bosYiYi = new BosYiYi
      bosYiYi.getBucketList.toList map { bucket =>
          println(bucket.getName)
      }
      println("==============================================")
      ok
    }
  }
}
