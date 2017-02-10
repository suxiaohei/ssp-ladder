package com.example.scala

import org.specs2.mutable.Specification

/**
  * Created by suxin on 17-2-7.
  */
class GenericTest extends Specification {

  "GenericTest" should {
    "covariant" in {

      class Animal {}
      class Bird0 extends Animal
      class Bird extends Bird0 {
        def printBird = {
          println("bird")
        }
      }

      class Pigeon extends Bird {}

      class Consumer[+T] {
        def use[U >: T](u: U): U = {
          println(u)
          u
        }
      }
      //      class FInvok {
      //        def invok(con: Consumer[Pigeon]) = {
      //          //          con.use(new Bird)
      //        }
      //      }
      case class Book()
      val con_bird = new Consumer[Bird0]
      val a = con_bird.use(new Animal)
      a
      val t = con_bird.use(new Pigeon)
      t
      val s = con_bird.use(Nil)
      s
      val test: Consumer[Animal] = con_bird
      test.use(new Animal())
      test.use(Book())
      val list = List[Book](Book())
      val x = 23 :: list
      println(x)
      println(x.getClass)
      //      val fi = new FInvok
      //      val con_pigeon = new Consumer[Pigeon]
      //      fi.invok(con_pigeon)
      ok
    }
    "upper bounds" in {

      class Animal {}
      class Bird extends Animal {}

      class Consumer[T] {
        def use[U <: T](u: U) = {
        }
      }

      val c = new Consumer[Animal]
      val c1 = new Consumer[Bird]
      c.use(new Bird)

      /** type mismatch **/
      //      c1.use(new Animal)
      ok
    }

    "book" in {
      //出版物类
      class Publication(val title: String)
      //书籍类
      class Book(title: String) extends Publication(title)
      //图书库类
      object Library {
        //定义图书库内所有的书籍
        val books: Set[Book] =
          Set(
            new Book("Programming in Scala"),
            new Book("Walden")
          )

        //打印所有图书内容，使用外部传入的函数来实现
        def printBookList(info: Book => AnyRef) {
          //确认Scala中一个参数的函数实际上是Function1特征的实例
          assert(info.isInstanceOf[Function1[_, _]])
          //打印
          for (book <- books)
            println(info(book))
        }

        //打印所有图书内容，使用外部传入的GetInfoAction特征的实例来实现
        def printBokkListByTrait[P >: Book, R <: AnyRef](
                                                          action: GetInfoAction[P, R]) {
          //打印
          for (book <- books)
            println(action(book))
        }

      }
      //取得图书内容特征，P类型参数的类型下界是Book，R类型参数的类型上界是AnyRef
      trait GetInfoAction[P >: Book, R <: AnyRef] {
        //取得图书内容的文本描述，对应（）操作符
        def apply(book: P): R
      }
      //定义取得出版物标题的函数
      def getTitle(p: Publication): String = p.title
      //使用函数来打印
      Library.printBookList(getTitle)

      //使用特征GetInfoAction的实例来打印
      Library.printBokkListByTrait(new GetInfoAction[Publication, String] {
        def apply(p: Publication): String = p.title
      })
      ok
    }
  }
}
