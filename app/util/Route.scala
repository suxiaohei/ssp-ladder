package util

import com.google.inject.{Inject, Singleton}
import play.api.Configuration

/**
  * Created by suxin on 17-1-5.
  */
@Singleton
class RouteTest @Inject() (_configuration: Configuration) {

  protected def configuration: Configuration = _configuration

  println("test=====================================")
}

object RouteTest {

  def configuration: Configuration = _current.configuration

  private lazy val _current: RouteTest = play.api.Play.current.injector.instanceOf(classOf[RouteTest])

}
