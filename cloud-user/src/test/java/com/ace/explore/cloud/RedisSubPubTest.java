package com.ace.explore.cloud;

import com.ace.explore.cloud.constant.RedisKeys;
import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangwanli on 2018/6/8.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RedisSubPubTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static Random random = new Random();

    @Test
    public void pubsub() throws Exception {
        for (int i = 0; i < 10; i++) {
            pub();
        }
        TimeUnit.SECONDS.sleep(30);
    }

    private void pub() {
        News news = new News()
                .setId(UUID.randomUUID().toString())
                .setTitle("title" + random.nextInt(5000))
                .setContent("content" + random.nextInt(1000));
        redisTemplate.convertAndSend(RedisKeys.Channel.NEWS, JSON.toJSONString(news));
        //        redisTemplate.convertAndSend(RedisKeys.Channel.NEWS, news);
    }

}

@Setter
@Getter
@Accessors(chain = true)
class News {
    private String id;
    private String title;
    private String content;
    private Date time;
}
