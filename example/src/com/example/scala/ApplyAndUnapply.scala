package com.example.scala

/**
  * Created by suxin on 16-11-30.
  */
class ApplyAndUnapply {
  def apply: ApplyAndUnapply = new ApplyAndUnapply()
}

object ApplyAndUnapply {
  def unapply(str: String): Option[Int] = {
    str.split(" ").toList map println
    Some(1)
  }
}
