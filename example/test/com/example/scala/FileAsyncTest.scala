package com.example.scala

import java.io.{FileWriter, PrintWriter}

import org.specs2.mutable.Specification

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by suxin on 16-12-20.
  */
class FileAsyncTest extends Specification {

  "FileAsyncTest" should {
    "writeFileAsync" in {

      for(i <- 1 to 1000) {
        val file = new java.io.File("/home/suxin/文档/近期项目中技术实现问题总结1.txt")
        val write = new PrintWriter(file)
        Future{
          println(i)
          write.write("test " + i)
          write.close()
        }
      }
      ok
    }
    "writeFileAsync2" in {
      val list = 1 to 100
      Future.traverse(list) { v =>
        Future{
          val file = new java.io.File("/home/suxin/文档/近期项目中技术实现问题总结1.txt")
          val write = new PrintWriter(new FileWriter(file, true))
          write.println("test " + v)
          write.close()
        }
      }
      ok
    }
  }
}
