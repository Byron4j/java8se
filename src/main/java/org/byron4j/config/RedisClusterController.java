package org.byron4j.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisClusterController {

    @Autowired
    @Qualifier("redisClusterService")
    private IRedisCluster redisCluster;

    @PostMapping("/cluster/jedis/{key}")
    public void setDataByJedis(@PathVariable("key") String key){
        System.out.println("set " + key);
        redisCluster.set(key,key + "nice");
    }

    @GetMapping("/cluster/jedis/{key}")
    public void getDataByJedis(@PathVariable("key") String key){
        System.out.println(redisCluster.get(key));
    }


}