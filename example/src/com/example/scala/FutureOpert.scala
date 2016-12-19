package com.example.scala

import scala.concurrent.Future

/**
  * Created by suxin on 16-12-1.
  */
class FutureOpert {

}

object FutureOpert {
  def throwE = {
    Future.failed(new RuntimeException("test333333"))
  }
}
