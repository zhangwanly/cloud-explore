package com.ace.cloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by zhangwanli on 2018/7/6.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MobileApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MobileApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

}
