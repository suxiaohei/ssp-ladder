package com.example.scala

import anorm._
import anorm.SqlParser._


case class Persion(id: String, name: String, age: Int, phone: Int)

class Persion1(id: String, name: String, age: Int, phone: Int) {

}

/**
  * Created by suxin on 16-12-2.
  */
class Symbol {
  val persion_model = str("id") ~ str("name") ~ int("age") ~ int("phone") map {
    case id ~ name ~ age ~ phone =>
      Persion(id, name, age, phone)
  }
}

object main extends App {

  val p = Persion("2", "3", 2, 2)
  val p1 = new Persion1("2", "2", 2, 2)

  p match {
    case Persion(id, name, age, phone) => println(s"Persion is $id $name")
  }

}
