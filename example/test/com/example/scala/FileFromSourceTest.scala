package com.example.scala

import java.io.PrintWriter

import org.apache.commons.io.{FileUtils, IOUtils}
import org.specs2.mutable.Specification

import scala.io.Source

/**
  * Created by suxin on 16-12-5.
  */
class FileFromSourceTest extends Specification {

  "FileFromSourceTest" should {
    "fromLocal" in {

      val file = new java.io.File("/home/suxin/sql/ask")
      val source = Source.fromFile(file, "GB18030")
      for (line <- source.getLines()) println(line)
      ok
    }

    "fromUrl" in {

      val url = new java.net.URL("http://pic33.nipic.com/20130916/3420027_192919547000_2.jpg")
      val open = url.openConnection
      val inputStream = open.getInputStream
      val fs: java.io.FileOutputStream = new java.io.FileOutputStream("/home/suxin/3420027_192919547000_2.jpg");
      IOUtils.copy(inputStream, fs)
      fs.close()
      inputStream.close()
      ok
    }

    "write" in {
      val write = new PrintWriter(new java.io.File("/home/suxin/test.list"),"GB18030")
      for (a <- 1 to 10) {
        write.write(a + "\n")
      }
      write.close()
      ok
    }

    "test" in {
      val list = List(1,2,3,4,5,6)
      val list1 = list.map{ num =>
      }
      list1.map{ println(_)}
      ok
    }
  }
}
