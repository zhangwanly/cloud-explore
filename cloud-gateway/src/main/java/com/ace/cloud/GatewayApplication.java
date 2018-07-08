package com.ace.cloud;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by zhangwanli on 2018/6/12.
 */
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder().web(WebApplicationType.SERVLET).bannerMode(Banner.Mode.CONSOLE).run(args);
    }

}
