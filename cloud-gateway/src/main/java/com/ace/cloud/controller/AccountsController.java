package com.ace.cloud.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhangwanli on 2018/6/12.
 */
@RestController
@RequestMapping("/account")
@Api(tags = "account", description = "账户相关接口")
public class AccountsController {

    @GetMapping("/aaa")
    @ApiOperation(value = "你好", tags = {"新增于 5.1.8"})
    public String hello(String name) {
        return "hello " + name;
    }

    @GetMapping("/bbb")
    @ApiOperation(value = "你好", tags = "新增于 5.1.9")
    public String helloAgain(String name) {
        return "hello " + name;
    }

}
