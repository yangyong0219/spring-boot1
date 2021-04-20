package com.example.redisserver.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/redis/server")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @PostMapping("/helloRedis")
    public String testRedis(@RequestBody String data){
        ValueOperations valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("aassaaaaaa", "aasasss");

        HashOperations hashOperations = stringRedisTemplate.opsForHash();
        Map<String, String> map = new HashMap<>();
        map.put("aassa", "我爱中国");

        hashOperations.putAll("1asa", map);
        System.out.println(data);
        return data;
    }
}
