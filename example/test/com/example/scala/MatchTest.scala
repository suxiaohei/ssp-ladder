package com.example.scala

import org.specs2.mutable.Specification
import anorm._
import anorm.SqlParser._
import org.specs2.execute.{AsResult, Result}
import play.api.db.DB
import play.api.test.WithApplication
import spray.json.JsNull

/**
  * Created by suxin on 16-12-27.
  */
class MatchTest extends Specification {

  abstract class WithDbData extends WithApplication {
    override def around[T: AsResult](t: => T): Result = super.around {
      setupData()
      t
    }

    def setupData() {
      // setup data
    }
  }

  private val db = DB

  "MatchTest" should {
    "MatchSome" in {

      val strOpt = (Some(123), Some(456), Some(789))

      strOpt match {
        case (Some(v1), optTest@(Some(123) | Some(101)), Some(v3)) => println(optTest)
        case _ => println("空")
      }
      ok
    }

    "MatchSome1" in new WithDbData {

      val seq = Seq(1, 2, 4, 5)
      val result = db.withConnection("default") { implicit c =>
        SQL"""select count(*) as c from test where id in (${seq})""".as(SqlParser.int("c").singleOpt)
        //        SQL"""select * from test where id in ({seq})""".on('seq -> seq).execute()
      }
      println(result + "=============================================================")
      ok
    }

    "MatchSome2" in {
      val x = Map("one" -> 1, "two" -> 2, "three" -> 3)

      List("1" -> 2, "2" -> 3)  map println
      ok
    }

    "MatchSome3" in {
      val opt1 = None
      val opt2 = Option{null}
      val opt3 = Option{0}
      println(opt1.isDefined)
      println(opt2.isDefined)
      println(opt3.isDefined)
      ok
    }

    "MatchSome4" in {
      val opt1 = Option{1}
      val opt2 = Some{0}
      opt1 match {
        case Some(i) => println(i)
        case _ => 1
      }
      opt2 match {
        case Some(i) => println(i)
        case _ => 1
      }
      println(opt1.isDefined)
      println(opt2.isDefined)
      ok
    }

    "MatchSome5" in  {
      println(JsNull)
      ok
    }
  }
}
