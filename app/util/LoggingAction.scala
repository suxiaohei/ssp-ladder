package util

import play.api.mvc._
import scala.concurrent.Future

/**
  * Created by suxin on 16-11-24.
  */
object LoggingAction extends ActionBuilder[Request] {

  override def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]) = {
    println("Calling Action")
    block(request)
  }

}
