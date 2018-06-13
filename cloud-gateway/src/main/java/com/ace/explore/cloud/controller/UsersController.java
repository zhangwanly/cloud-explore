package com.ace.explore.cloud.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangwanli on 2018/6/12.
 */
@RestController
@RequestMapping("/user")
public class UsersController {

    @GetMapping("/hello")
    @ApiOperation(value = "你好")
    public String hello(String name) {
        return "hello " + name;
    }

}
