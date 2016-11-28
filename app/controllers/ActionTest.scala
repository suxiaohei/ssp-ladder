package controllers

import play.api.libs.json.JsValue
import play.api.mvc._
import java.io.File

import util.LoggingAction

/**
  * Created by suxin on 16-11-10.
  */
object ActionTest extends Controller {

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
    Ok("Got body [" + parse.json + "]")
  }

  def okMessageImpInBrowerGet() = Action { implicit request =>
    implicit val myCustomCharset = Codec.javaSupported("iso-8859-1")
    //    Ok(<message>Hellow World!</message>)
    //    Ok(<h1>Hellow World!</h1>).as("text/html")
    Ok(<h1>Hellow World!</h1>).as(HTML)
    //    val result = Ok("Hello World").withHeaders(CACHE_CONTROL -> "max-age=3600", ETAG -> "xx")
    //    val result2 = result.discardingCookies(DiscardingCookie("theme"))
    //    val result3 = result.withCookies(Cookie("theme","blue")).discardingCookies(DiscardingCookie("skin"))
    //    result
  }

  def okSessionInBrowerGet = Action { request =>
    request.session.get("connected").map { user =>
      Ok("Hello" + user)
    }.getOrElse {
      Unauthorized("Oops , you are not connected")
    }
  }

  def tokenJson = Action { request =>
    val body: AnyContent = request.body
    val jsonBoyd: Option[JsValue] = body.asJson

    jsonBoyd.map { json =>
      Ok("Got ： " + (json \ "name").as[String])
    }.getOrElse {
      BadRequest("Expection application/json request body")
    }
  }

  def tokenJson2 = Action(parse.json) { request =>
    Ok("Got ： " + (request.body \ "name").as[String])
  }

  def tokenJson3 = Action(parse.tolerantJson) { request =>
    Ok("Got : " + (request.body \ "name").as[String])
  }

  def tokenJson4 = Action(parse.file(to = new File("/home/suxin/下载/test.txt"))) { request =>
    Ok("Save the request to " + request.body)
  }

  def tokenJson5 = LoggingAction { request =>
    Ok("Save the request to " + request.body)
  }

//  val storeInUserFile = parse.using { request =>
//    request.session.get("username").map { user =>
//      file(to = new File("/tmp/" + user + ".upload"))
//    }.getOrElse {
//      sys.error("You don't have the right to upload here")
//    }
//  }
//
//  def tokenJson5 = Action(storeInUserFile) { request =>
//    Ok("Save the request content to " + request.body)
//  }

}
