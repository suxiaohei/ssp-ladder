package scala.traitL

object Test {
  def main(args: Array[String]): Unit = {
    //01  添加特性
    val acct = new SavingAccount with ConsoleLogger
    acct.withdraw("Test")

    //02 
    val acct1 = new SavingAccount with ConsoleLogger with TimestampLogger with ShortLogger

    acct1.withdraw("Insufficient funds")

    val acct2 = new SavingAccount with ConsoleLogger with ShortLogger with TimestampLogger

    acct2.withdraw("Insufficient funds")
  }
}