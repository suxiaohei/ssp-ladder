package scala.file

import scala.io.Source

class ReadFile {

  /**
   * 从本地读取文件
   */
  def readFileFromTxt: Unit = {
    val source = Source.fromFile("C://Users//Administrator//Desktop//常用maven命令.txt", "UTF-8")
    val lineIterator = source.getLines()
    //遍历每行的数据
    for (line <- lineIterator)
      println(line)

    //可以放到数组或者缓冲数组中
    val lines = source.getLines().toArray
    for (line <- lines)
      println(line)

    var contents = source.mkString
    println(contents)

    source.close()
  }
  
  def readFileFromWeb : Unit = {
    var sourceUrl = Source.fromURL("http://www.baidu.com","UTF-8")
    val lineIterator = sourceUrl.getLines()
    //遍历每行的数据
    for (line <- lineIterator)
      println(line)
      
    sourceUrl.close()
  }
}

object ReadFile {//伴生对象

  def main(args: Array[String]): Unit = {
    var readFile = new ReadFile
    readFile.readFileFromWeb
  }
}