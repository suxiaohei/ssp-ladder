package scala.apply

class Account private (var id: Int, initialBalance: Double) {
  private var balance = initialBalance

  println(id);
  println(initialBalance);

  //主构造器
  def Account(id: Int, initialBalance: Double) {
    println(id);
    println(initialBalance);
  }

}

object Account { //半生对象

  def main(args: Array[String]): Unit = {
    //使用apply方法
    val acct = Account(1000.0)
    //使用构造器
    var act2 = new Account(222, 222)
  }

  private var lastNumber = 0

  private def newUniqueNumber() = {
    lastNumber += 1; lastNumber
  }

  def apply(initialBalance: Double) = new Account(newUniqueNumber(), initialBalance)
}