package com.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;

//redis 集群
public class Cluster {

    public static void main(String[] args) throws IOException {
        //创建对象
        HostAndPort hostAndPort = new HostAndPort("47.96.175.143", 6379);
        //现在集群有3台主机，3台从机，每台都是root密码访问
        JedisCluster jedisCluster = new JedisCluster(hostAndPort, 1000, 1000,
                10, "root", new JedisPoolConfig());

        jedisCluster.set("z3", "v2");

        String value = jedisCluster.get("z3");
        System.out.println("值为： " + value);

        jedisCluster.close();
    }
}
