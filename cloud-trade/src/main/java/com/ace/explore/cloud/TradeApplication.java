package com.ace.explore.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by zhangwanli on 2018/5/21.
 */
@SpringBootApplication
@EnableEurekaClient
public class TradeApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TradeApplication.class).web(true).run(args);
    }

}
