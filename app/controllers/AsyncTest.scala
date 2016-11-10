package controllers

import play.api.mvc._

/**
  * Created by suxin on 16-11-10.
  */
object AsyncTest  extends  Controller{

  def printInBrower() = Action {
      Ok("tset")
  }
}
