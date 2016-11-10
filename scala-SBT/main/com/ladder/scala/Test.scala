package scala

import scala.util.control.Breaks._

object Test {

  private[this] var age = 0

  def main(args: Array[String]): Unit = {
    this.age = 10
    println(this.age)

    // : _*是作为参数序列处理
    sum(1 to 5: _*)
  }

  /**
   * 定义带有返回值的函数
   */
  def helloWorld(): String = {
    val str = "Hello World"
    str
  }

  /**
   * 高级for循环1,先计算i,后递增j并执行完j所生成的集合再计算i
   */
  def forTest1(): Unit = {
    for (i <- 1 to 3; j <- 1 to 3)
      print((10 * i * j) + "* ")
  }

  /**
   * 高级for循环2,先计算i并计算出test,后递增j并执行完j所生成的集合再计算i并计算出test
   */
  def forTest2(): Unit = {
    for (i <- 1 to 3; test = 4 - i; j <- test to 3)
      print((10 * i * j) + "* ")
  }

  /**
   * for退导论,生成集合的类型与第一个生成器的类型兼容
   * 高级for循环3 , 计算结果构造出一个集合Vector
   */
  def forTest3(): Unit = {
    val vc = for (i <- 1 to 10) yield i % 3
    print(vc)
  }

  /**
   * 高级for循环3 ,until 返回一个并不包含上限的区间
   */
  def forTest4(): Unit = {
    val s = "Hello"
    var sum = 0
    for (i <- 0 until s.length())
      sum += s(i)

    print(sum + " ")
  }

  /**
   * 使用breakable退出for循环
   */
  def forTest5(): Unit = {
    breakable {
      for (i <- 0 to 10) {
        print(i);
        if (i == 5)
          break
      }
    }
    print("执行成功")
  }

  /**
   * 递归函数，必须定义返回类型
   */
  def fac(n: Long): Long = if (n <= 0) 1 else n * fac(n - 1)

  /**
   * 变长参数，Int*表示
   */
  def sum(args: Int*) = {
    var result = 0;
    for (arg <- args) result += arg
    print(result)
    result
  }

}