package controllers

import java.io.InputStream

import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.iteratee.Enumerator
import play.api.mvc._

/**
  * Created by suxin on 16-11-25.
  */
object ActionAsyncTest extends Controller {

  //return With Content-Length
  def idnex = Action {

    val file = new java.io.File("/home/suxin/下载/test2/sanofi001-ftp.csv")
    val emumer:Enumerator[Array[Byte]] = Enumerator.fromFile(file)
    Result(
      header = ResponseHeader(200,Map(CONTENT_LENGTH -> file.length.toString)), body = emumer
    )
  }
}
