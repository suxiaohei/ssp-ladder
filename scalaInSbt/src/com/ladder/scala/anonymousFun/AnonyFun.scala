package scala.anonymousFun

import scala.math._

/**
 * 高阶函数——匿名函数
 */
class AnonyFun {

  //map可以接受函数
  def mathCeil(): Unit = {
    val num = 3.14
    val fun = ceil _

    println(fun(num))

    for (ar <- Array(3.14, 1.42, 2.0) map fun) println(ar)
  }

  val triple = (x: Double) => 3 * x
  //带函数参数的函数,高阶函数
  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)
  //产出另一个函数
  def mulBy(factor: Double) = (x: Double) => factor * x
}

object AnonyFun {
  def main(args: Array[String]): Unit = {
    val anonyFun = new AnonyFun
    //    anonyFun.mathCeil()

    //    println(anonyFun.triple(3))
    //输出高阶函数结果
    //    println(anonyFun.valueAtOneQuarter(ceil _))
    //    println(anonyFun.valueAtOneQuarter(sqrt _))

    //产出另一个函数
    var quintuple = anonyFun.mulBy(4)
    println(quintuple(20))

  }
}