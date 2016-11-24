package controllers

import play.api.mvc._

import util.LoggingAction

/**
  * Created by suxin on 16-11-10.
  */
object LoggingActionTest extends Controller {

  def tokenJson = LoggingAction { request =>
    Ok("Save the request to " + request.body)
  }
}
