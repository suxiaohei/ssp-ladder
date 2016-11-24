package controllers

import play.api.mvc._

import util.LoggingAction

/**
  * Created by suxin on 16-11-10.
  */
object LoggingActionTest extends Controller {

  def index = LoggingAction { request =>
    Ok("Save the request to " + request.body)
  }

  def submit = LoggingAction(parse.text){ request =>
    Ok("Got body  " + request.body.length + " body long")
  }
}
