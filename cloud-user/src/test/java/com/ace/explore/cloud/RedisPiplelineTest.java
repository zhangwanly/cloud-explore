package com.ace.explore.cloud;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by zhangwanli on 2018/6/8.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RedisPiplelineTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void pipleline() {
        List<Object> list = redisTemplate.executePipelined((RedisCallback<List<Object>>) connection -> {
            String key = "players";
            StringRedisSerializer serializer = new StringRedisSerializer();
            connection.zAdd(serializer.serialize(key), 100.00, serializer.serialize("zwl"));
            connection.zAdd(serializer.serialize(key), 102.00, serializer.serialize("xtx"));
            connection.zAdd(serializer.serialize(key), 103.00, serializer.serialize("lxl"));
            return null;
        });
        log.info("rs={}", list);
    }

}
