package scala.file

import java.io.PrintWriter

class WriteFile {

  def writeFileToTxt: Unit = {
    val out = new PrintWriter("C://Users//Administrator//Desktop//number.txt")
    //输入
    for (i <- 1 to 100) out.println(i)
    //输入数字时，若使用printf则需要使用格式化，转换为string
    for (i <- 1 to 100) out.printf("%6d %10.2f".format(10, 11.22))

    out.close()
  }
}

object WriteFile {
  def main(args: Array[String]): Unit = {
    val writeFile = new WriteFile
    writeFile.writeFileToTxt
  }
}