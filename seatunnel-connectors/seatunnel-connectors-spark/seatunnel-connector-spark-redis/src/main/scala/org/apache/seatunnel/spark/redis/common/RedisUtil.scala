/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.seatunnel.spark.redis.common

import com.redislabs.provider.redis.{RedisConfig, RedisEndpoint}
import org.apache.seatunnel.shade.com.typesafe.config.Config
import org.apache.seatunnel.spark.redis.common.Constants.{AUTH, DB_NUM, HOST, PORT, TIMEOUT}

object RedisUtil {
  def getRedisConfig(isSelfAchieved: Boolean, config: Config): RedisConfig = {
    if (isSelfAchieved) {
      new SelfAchievedRedisProxyConfig(RedisEndpoint(
        host = config.getString(HOST),
        port = config.getInt(PORT),
        auth = if (config.getIsNull(AUTH)) null else config.getString(AUTH),
        dbNum = config.getInt(DB_NUM),
        timeout = config.getInt(TIMEOUT)
      ))
    } else {
      new RedisConfig(RedisEndpoint(
        host = config.getString(HOST),
        port = config.getInt(PORT),
        auth = if (config.getIsNull(AUTH)) null else config.getString(AUTH),
        dbNum = config.getInt(DB_NUM),
        timeout = config.getInt(TIMEOUT)
      ))
    }
  }
}
