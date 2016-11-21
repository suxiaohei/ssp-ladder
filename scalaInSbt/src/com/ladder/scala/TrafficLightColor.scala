package scala

/**
 * 实现枚举
 */
object TrafficLightColor extends Enumeration {

  def main(args: Array[String]): Unit = {
    //根据id输出
    println(TrafficLightColor(0))
    //根据名称输出
    println(TrafficLightColor.withName("Go"))
  }

  val Red = Value(0, "Stop")
  val Yellow = Value(10) //缺省名称为字段名
  val Green = Value("Go") //id为上一个值基础上加1
}