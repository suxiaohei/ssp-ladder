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
      class Consumer[+T](t:T) {
        def use[U >: T](u: U):T= {
          println(t)
          t
        }
      }
      class FInvok {
        def invok(con : Consumer[Bird]) = {
          con.use()
        }
      }
      val con_pigeon = new Consumer[Pigeon](new Pigeon)
      val fi = new FInvok
      fi.invok(con_pigeon)
      ok
    }
    "upper bounds" in {

      class Animal {}
      class Bird extends Animal {}

      class Consumer[-T](t: T) {

      }
      ok
    }
  }
}
