package com.example.scala

import org.specs2.mutable.Specification

/**
  * Created by suxin on 16-12-2.
  */
class SymbolTest extends Specification {

  "SymbolTest" should {
    "persion_model" in {
      val p = new Symbol
      val jsObj =
      p.persion_model
      ok
    }

  }
}
