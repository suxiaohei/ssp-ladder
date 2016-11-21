package scala.traitL

class SavingAccount extends Logged {
  def withdraw(amount: String) {
    if (true) log(amount)
    else log("false")
  }
}

class SavingAccount2 extends Logger {
  def withdraw(amount: String) {
    if (true) severe(amount)
    else log("false")
  }

  override def log(msg: String) { println(msg + "  " +new java.util.Date) }
}

object SavingAccount2{
  def main(args: Array[String]): Unit = {
    val acct = new SavingAccount2
    acct.withdraw("Test")
  }
}