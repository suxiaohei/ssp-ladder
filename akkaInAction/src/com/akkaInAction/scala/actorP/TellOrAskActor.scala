//package com.akkaInAction.scala.actorP
//
//import java.util.concurrent.TimeUnit
//
//import akka.actor.{Actor, ActorSystem, Props}
//import akka.util.Timeout
//import akka.pattern.{ask, pipe}
//
//import scala.concurrent.{ExecutionContext, Future}
//
//
//final case class Result(x: Int, s: String, d: Double)
//
//case object Request
//
///**
//  * Created by suxin on 16-11-28.
//  */
//class TellOrAskActor extends Actor {
//
//  implicit val timeout = Timeout(5, TimeUnit.SECONDS)
//  implicit val ec: ExecutionContext = context.dispatcher
//
//  override def receive = {
//    case Request => println("is Request")
//    case _ => println("is no select")
//  }
//
//
//
//}
//
//object TellOrAskActor extends App {
//
//  val system = ActorSystem("tellOrAsk")
//  val actorA = system.actorOf(Props[TellOrAskActor], "actorA")
//  val actorB = system.actorOf(Props[TellOrAskActor], "actorB")
//  val actorC = system.actorOf(Props[TellOrAskActor], "actorC")
//  val actorD = system.actorOf(Props[TellOrAskActor], "actorD")
//
//  val f: Future[Result] = {
//    for {
//      x <- ask(actorA, Request).mapTo[Int]
//      y <- ask(actorB, Request).mapTo[String]
//      z <- ask(actorC, Request).mapTo[Double]
//    } yield Result(x, y, z)
//  }
//  //  f.pipeTo(actorD)
//
//}
