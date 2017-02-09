package com.example.scala

import org.specs2.mutable.Specification

/**
  * Created by suxin on 17-2-7.
  */
class GenericTest extends Specification {

  "GenericTest" should {
    "covariant" in {

      class Animal {}
      class Bird extends Animal {}
      class Pigeon extends Bird {}
      class Consumer[+T] {
        def use[U >: T](u: U) = {
          println(u)
        }
      }
      class FInvok {
        def invok(con: Consumer[Bird]) = {
          con.use(new Bird)
          con.use(new Animal)
          con.use(new Pigeon)
        }
      }

      val con_pigeon = new Consumer[Bird]
      val fi = new FInvok
      fi.invok(con_pigeon)
      ok
    }
    "upper bounds" in {

      class Animal {}
      class Bird extends Animal {}

      class Consumer[T] {
        def use[U <: T](u: U) = {
        }
      }

      val c = new Consumer[Animal]
      val c1 = new Consumer[Bird]
      c.use(new Bird)
//      c1.use(new Animal) /**type mismatch**/
      ok
    }
  }
}
