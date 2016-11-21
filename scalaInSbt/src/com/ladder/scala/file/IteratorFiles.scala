package scala.file

import java.io.File
import java.nio.file._

class IteratorFiles {
  /**
   * 遍历所有子目录
   */
  def subdirs(dir: File): Iterator[File] = {
    val children = dir.listFiles().filter(_.isDirectory())
    children.toIterator ++ children.toIterator.flatMap(subdirs _)
  }

  /**
   * 打印所有子目录
   */
  implicit def makeFileVisitor(f: (Path) => Unit) = new SimpleFileVisitor[Path] {
    override def visitFile(p: Path, attrs: attribute.BasicFileAttributes) = {
      f(p)
      FileVisitResult.CONTINUE
    }
  }
}

object IteratorFiles {

  def main(args: Array[String]): Unit = {
    val iteratorFiles = new IteratorFiles
    val dir = new File("C://Users//Administrator//Desktop")
    //    for (d <- iteratorFiles.subdirs(dir)) println(d)
    //    Files.walkFileTree(dir.toPath, (f: Path) => println(f))
    //    Files.walkFileTree(dir.toPath, (f: Path) => println(f))
  }
}