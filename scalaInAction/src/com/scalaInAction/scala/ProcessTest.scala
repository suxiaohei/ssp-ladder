package com.scalaInAction.scala

import scala.sys.process._
import scala.io.Source
import java.io.File
import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

/**
  * Created by suxin on 16-11-23.
  */
class ProcessTest {

}

object ProcessTest {

  def main(args: Array[String]) {
    print(dataFor)
  }

  def dataFor(): String = {
    val str = "2016-11-23-15-2-33-958-sanofi001-auto.csv.zip"

    val p = """[\d-]+""".r
    val t =  p.findFirstIn(str).getOrElse("")
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")
    val cal:Calendar =Calendar.getInstance();
    cal.getTimeInMillis
    cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - 1)

    println(dateFormat.parse(t).after(cal.getTime))
    print(dateFormat.format(dateFormat.parse(t)))
    ""
  }

  def test() : Unit = {
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")
    var cal:Calendar =Calendar.getInstance();
    cal.getTimeInMillis
    cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - 1)
    val endDate = dateFormat.format(cal.getTime());
    print(endDate)
  }

  def processToTest(): Unit = {
    val path = "/home/suxin/下载/test2/*.zip"
    val outPath = "/home/suxin/下载/test2/"
    //    val echo = "/home/suxin/下载/test.sh "+ path +" " + outPath !
    val d: Date = new Date()

    "7z e /home/suxin/下载/test2/*.zip -o/home/suxin/下载/test2/ -aou" !
    val file = new File("/home/suxin/下载/test2/")
    val childrenList = file.listFiles().filter(f => f.isFile && f.getName.endsWith(".csv")).toList

    childrenList.map(f => {
      val sources = Source.fromFile(f, "gbk")
      val finaSour = sources.getLines().toList.drop(1)
      for (line <- finaSour) {
        println(line.trim)
      }
      f.delete()
    })
  }

  def getNowDate(): String = {
    val now: Date = new Date()
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")
    val hehe = dateFormat.format(now)
    print(hehe)
    hehe
  }

}
