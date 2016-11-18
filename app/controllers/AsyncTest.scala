package controllers

import play.api.mvc._

/**
  * Created by suxin on 16-11-10.
  */
object AsyncTest extends Controller {

  def printInBrowerGet() = Action {
    Ok("tset")
  }

  def okResponInBrowerGet() = Action { request =>
    Ok("Got request [" + request + "]")
  }

  def okResponImpInBrowerGet() = Action { implicit request =>
    Ok("Got request [" + request + "]")
  }

  def okResponImpInBrowerPost() = Action(parse.json) { implicit request =>
    Ok("Got request [" + request + "]")
  }
}
