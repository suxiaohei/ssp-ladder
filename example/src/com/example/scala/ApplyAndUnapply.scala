package com.example.scala

/**
  * Created by suxin on 16-11-30.
  */
class ApplyAndUnapply {
  def apply() = {
    println("==================CLass Apply==================")
  }
}

object ApplyAndUnapply {

  def apply() = {
    println("==================Object Apply==================")
  }

  def unapply(str: String): Option[Int] = {
    str.split(" ").toList map println
    Some(1)
  }
}
