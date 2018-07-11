package com.ace.cloud.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangwanli on 2018/6/12.
 */
@RestController
@RequestMapping("/user")
@Api(tags = "user", description = "用户相关接口")
public class UsersController {

    @GetMapping("/hello")
    @ApiOperation(value = "你好", tags = {"新增于 5.1.8", "修改于 5.1.9"})
    public String hello(String name) {
        return "hello " + name;
    }

    @GetMapping("/hello-again")
    @ApiOperation(value = "你好", tags = {"新增于 5.2.0"})
    public String helloAgain(String name) {
        return "hello " + name;
    }


    @GetMapping("/xxxx")
    @ApiOperation(value = "你好")
    public String helloXxx(String name) {
        return "hello " + name;
    }

}
