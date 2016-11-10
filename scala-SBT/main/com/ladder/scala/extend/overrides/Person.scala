package scala.extend.overrides

class Person {

  val name = "Test"

  override def toString = getClass.getName + "[name = " + name + "]"
}

class Employee extends Person {

  override def toString = super.toString() + "[salary =  " + name + "]"

}

//抽象类重写
abstract class Person1 {

  val id: Int

}

//def,val(可以重写不带参数的def),var只能重写对应的参数
class Student(override val id: Int) extends Person1

/**
 * @author Administrator
 */
object Employee {
  def main(args: Array[String]): Unit = {
    var em = new Employee()
    //    println(em.toString())

    //类型检查 return true
    println(em.isInstanceOf[Employee])
    //类型检查 return true
    println(em.isInstanceOf[Person])
    //强转,输出toString
    println(em.asInstanceOf[Employee])
  }
}