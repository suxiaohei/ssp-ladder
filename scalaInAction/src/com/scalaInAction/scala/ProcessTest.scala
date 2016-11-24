package com.scalaInAction.scala

import scala.sys.process._

/**
  * Created by suxin on 16-11-23.
  */
class ProcessTest {

}

object  ProcessTest{

  def main(args: Array[String]) {
    val list = "sudo unzip /home/suxin/下载/test/2016-11-23-15-1-51-182-sanofi001-auto.csv.zip" !

    println(list)
  }
}
