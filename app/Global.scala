import play.api.{Application, GlobalSettings, Logger}

/**
  * Created by suxin on 17-1-5.
  */
object Global extends GlobalSettings {

  override def onStart(app: Application) = {
    Logger.info("Application was Started==========================")
  }

}
