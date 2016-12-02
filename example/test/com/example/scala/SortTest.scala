package com.example.scala

import org.specs2.mutable.Specification

/**
  * Created by suxin on 16-12-1.
  */
class SortTest extends Specification {

  "SortTest" should {
    "qsort" in {

      ok
    }

    "main" in {
      import scala.util.Sorting

      val pairs = Array(("a", 4, 5), ("c", 1, 5), ("b", 2, 6))

      //根据_._1字段排序
      Sorting.quickSort(pairs)(Ordering.by[(String, Int, Int), String](_._1))

      Sorting.quickSort(pairs)(Ordering[(Int, Int)].on(x => (x._3 , x._2)))

      for (pair <- pairs) {
        println(pair)
      }

      ok
    }
  }
}
