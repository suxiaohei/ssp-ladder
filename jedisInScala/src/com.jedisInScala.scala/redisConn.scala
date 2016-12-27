package com.jedisInScala.scala

import redis.clients.jedis.{JedisPool, JedisPoolConfig}

/**
  * Created by suxin on 16-12-27.
  */
object RedisConn {

  def getConne(host: String, port: Int) = {
    val jedisPoolConfig = new JedisPoolConfig
    val jedisPool = new JedisPool(jedisPoolConfig, host, port, 3000)
    jedisPool.getResource()
  }
}
