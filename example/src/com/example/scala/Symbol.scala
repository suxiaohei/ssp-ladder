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
