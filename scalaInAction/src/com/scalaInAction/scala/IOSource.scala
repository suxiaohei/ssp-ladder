package com.scalaInAction.scala

import java.io.File
import scala.io.Source

/**
  * Created by suxiaohei on 16-11-21.
  */
class IOSource {

  def test(a:String): Unit= {

  }

}

object IOSource{

  def main(args: Array[String]): Unit = {
    IOSource.openFileAndPrint("/etc/acpi/asus-keyboard-backlight.sh")
  }

  def openFileAndPrint(path : String) : Unit =  {
    for (line <- Source.fromFile(new File(path), "utf-8").getLines()){
      print(line)
    }
  }
}
