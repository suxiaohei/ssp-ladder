package com.example.scala

/**
  * Created by suxin on 17-2-6.
  */
class MiscOpert {

  def funOverLoad = {
//    def fun1(i: Int) = {} /*代码片段中无法重载*/
    def fun1(str: String) = {}
  }

  def overload(i: Int): Int = i

  def overload(str: String): String = str
}

object MiscOpert {

  def apply(): MiscOpert = new MiscOpert()
}
