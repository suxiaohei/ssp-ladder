package com.akkaInAction.scala.common

import akka.actor.ActorSystem

/**
  * Created by suxin on 16-11-29.
  */
class CompletableApp(val setps: Int) extends App {

  val canComplete = new java.util.concurrent.CountDownLatch(1)

  val canStart = new java.util.concurrent.CountDownLatch(1)

  val completion = new java.util.concurrent.CountDownLatch(setps)

  val system = ActorSystem("ReactiveEnterprise")

  def awaitCanCompleteNow() = canComplete.await()

  def awaitCompletion() = {
    completion.await()
    system.terminate()
  }

  def canCompleteNow() = canComplete.countDown()

  def canStartNow() = canStart.countDown()

  def completeAll() = {
    while (completion.getCount > 0) {
      completion.countDown()
    }
  }

  def completedStep() = completion.countDown()

}
