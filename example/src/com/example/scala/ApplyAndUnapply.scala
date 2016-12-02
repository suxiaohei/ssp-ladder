package com.example.scala

/**
  * Created by suxin on 16-11-30.
  */
class ApplyAndUnapply {

  private val str = "Test apply and unApply"
  private val str1 = ""

  def apply: ApplyAndUnapply = new ApplyAndUnapply()

  def unapply(arg: ApplyAndUnapply): Option[Array[String]] = {
    Some(str1.split(" "))
  }

}
