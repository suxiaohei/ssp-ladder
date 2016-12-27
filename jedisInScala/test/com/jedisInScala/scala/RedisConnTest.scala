package com.jedisInScala.scala

import org.specs2.mutable.Specification
import redis.clients.jedis.{BinaryJedis, JedisPool, JedisPoolConfig}

/**
  * Created by suxin on 16-12-27.
  */
class RedisConnTest extends Specification {

  "redisConnTest" should {
    "getConne" in {

      val conn = RedisConn.getConne("127.0.0.1", 6379)
      conn.set("name", "sx")

      println(conn.get("name"))
      ok
    }

    "isEquale1" in {
      val jedisPoolConfig = new JedisPoolConfig
      jedisPoolConfig.setMaxTotal(2)
      jedisPoolConfig.setMaxIdle(2)
      val jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, 3000)

      val conn1 = jedisPool.getResource
      val conn2 = jedisPool.getResource
      if (conn1 == conn2) {
        println("相同")
      } else {
        println("不同")
      }

      conn1.close()
      conn2.close()
      ok
    }

    "isEquale2 not block" in {
      val jedisPoolConfig = new JedisPoolConfig
      jedisPoolConfig.setMaxTotal(1)
      jedisPoolConfig.setBlockWhenExhausted(false)
      val jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, 3000)

      val conn1 = jedisPool.getResource
      val conn2 = jedisPool.getResource
      if (conn1 == conn2) {
        println("相同")
      } else {
        println("不同")
      }
      conn1.close()
      conn2.close()
      ok
    }
  }
}
