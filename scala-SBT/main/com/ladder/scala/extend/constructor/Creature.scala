package scala.extend.constructor

class Creature {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature {
  override val range = 2
}

object Ant {
  def main(args: Array[String]): Unit = {
    var ant = new Ant()
    println(ant.range)
    //此处因为方法被重写，但还未被初始化，所以此时的range()是0
    println(ant.env.length)
  }
}