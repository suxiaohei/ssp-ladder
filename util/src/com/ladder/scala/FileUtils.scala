package com.ladder.scala

import java.io._
import java.nio.file._

import com.ladder.java.JzlibUtils

/**
  * Created by suxin on 16-11-21.
  */
class FileUtils {

}

object FileUtils {

  def main(args: Array[String]) {

    def files = FileUtils.scanFiles("/home/suxin/下载/BCA-1B")
    FileUtils.uncompress(files)
  }

  def scanFiles(dirPath: String): Iterator[File] = {
    val file = new File(dirPath)
    if (!file.isDirectory) println("当前路径不是目录")
    val children = file.listFiles().filter(f => f.isFile && f.getName.endsWith(".zip"))
    children.toIterator
  }

  def uncompress(files: Iterator[File]) = {
    files.foreach(f => JzlibUtils.unZip(f))
  }
}
