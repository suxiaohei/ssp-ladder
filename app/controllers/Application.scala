package controllers

import java.io.{FileOutputStream, InputStream}

import org.apache.commons.io.IOUtils
import play.api.Logger
import play.api.mvc._

import scala.async.Async._
import scala.concurrent.Future

object Application extends Controller {

  def index = Action {
    //    Ok(views.html.index("Your new application is ready."))
    Ok("Hello ")
  }

  def hello(name: String) = Action.async { request =>

    import scala.concurrent.ExecutionContext.Implicits.global

    async {
      await {
//        async {
//          val t1 = await {
            Future {
              var fileOutputStream: FileOutputStream = null
              var inputStream: InputStream = null
              val path = "http://wwww.baidu.com/avava.gif"
              try {
                val url = new java.net.URL(path)
                val open = url.openConnection
                open.setConnectTimeout(60000)
                open.setReadTimeout(60000)
                inputStream = open.getInputStream
                val fileRealDir = new java.io.File("/home/suxin/get.gif")
                fileOutputStream = new FileOutputStream(fileRealDir)

                IOUtils.copy(inputStream, fileOutputStream)
              } catch {
                case e: Exception =>
                  Logger.error(s"failed when read Case Img ${path}", e)
              } finally {
                if (fileOutputStream != null) {
                  fileOutputStream.close()
                }
                if (inputStream != null) {
                  inputStream.close()
                }
              }
//            }
//          }
        }
      }
      Ok("Hello " + name)
    }
  }
}