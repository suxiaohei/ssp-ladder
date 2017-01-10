package com.example.scala



/**
  * Created by suxin on 17-1-5.
  */
package swpage {

  class SwingType {
    def wantLearn(implicit sw: String) = {
      println("学习游泳")
    }
  }

}

object Swing {
  import com.example.scala.swpage.SwingType

  implicit def intConverString(i: Int) = i.toString
  implicit def learnToSwing(s: AminalType) = new SwingType
}

class AminalType

object AminalType extends App {

  import Swing._

  val rabit = new AminalType
  rabit.wantLearn(10)
}
