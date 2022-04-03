package org.byron4j.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisConfig {

    @Autowired
    private RedisClusterProperties redisClusterProperties;

    @Autowired
    private RedisPoolProperties redisPoolProperties;

    /* Jedis - 集群、连接池模式 */
    @Bean
    public JedisCluster jedisCluster(){

        /* 切割节点信息 */
        String[] nodes = redisClusterProperties.getNodes().split(",");
        Set<HostAndPort> hostAndPorts = new HashSet<>();
        for (String node : nodes) {
            int index = node.indexOf(":");
            hostAndPorts.add(new HostAndPort(node.substring(0,index),Integer.parseInt(node.substring(index + 1))));
        }

        /* Jedis连接池配置 */
        JedisPoolConfig jedisPoolConfig = getJedisPoolConfig();

        return new JedisCluster(hostAndPorts,redisClusterProperties.getCommandTimeout(),jedisPoolConfig);

    }

    /**
     * 连接池配置
     * @return JedisPoolConfig
     **/
    private JedisPoolConfig getJedisPoolConfig(){

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        jedisPoolConfig.setMaxIdle(redisPoolProperties.getMaxIdle());       // 最大空闲连接数, 默认8个
        jedisPoolConfig.setMaxTotal(redisPoolProperties.getMaxActive());    // 最大连接数, 默认8个
        jedisPoolConfig.setMinIdle(redisPoolProperties.getMinIdle());       // 最小空闲连接数, 默认0
        jedisPoolConfig.setMaxWaitMillis(redisPoolProperties.getMaxWait()); // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
        jedisPoolConfig.setTestOnBorrow(true);                              // 对拿到的connection进行validateObject校验
        return jedisPoolConfig;
    }

}