package com.example.scala

import scala.reflect.ClassTag
import scala.concurrent.Future

/**
  * Created by suxin on 16-12-5.
  */
class ClassTagT[ACT: ClassTag] {

  type Class_Type = ACT

  //val
}


