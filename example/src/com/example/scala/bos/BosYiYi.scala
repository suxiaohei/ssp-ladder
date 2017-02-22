package com.example.scala.bos

import com.baidubce.auth.DefaultBceCredentials
import com.baidubce.services.bos.{BosClient, BosClientConfiguration}

/**
  * Created by suxin on 17-2-16.
  */
class BosYiYi {

  def getBucketList = {
     BosYiYi.bosClient.listBuckets().getBuckets
  }
}

object BosYiYi {
  val ACCESS_KEY_ID = "F6c744d4a3e7827090a71f2fbdc9d426"
  val SECRET_ACCESS_ID = "F580c9f9e3f6920a5b78f917d4a78256"
  val bosClient = getClient

  def getClient = {
    val config = new BosClientConfiguration()
    config.setCredentials(new DefaultBceCredentials(ACCESS_KEY_ID, SECRET_ACCESS_ID))
    new BosClient(config)
  }

}
