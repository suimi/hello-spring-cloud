/*
 * Copyright (c) 2013-2015, 成都中联信通科技股份有限公司
 * Created by lichengcai on 2016-12-27.
 */
package com.suimi.hello.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("Aservice")
@Api(value = "Aservice",description = "A服务类")
@Slf4j
@RefreshScope
public class AController {

    @Value("${test}")
    private String value;

    @ApiOperation(value="api 测试", notes="只为测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "word",value = "hello word",required = true,dataType = "String")
    })
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    @HystrixCommand
    public String hello(String word) {
        log.info("hello {}", word);
        return "hello " + word;
    }

    @ApiOperation(value="测试", notes="测试方法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "word",value = "test word",required = true,dataType = "String")
    })
    @RequestMapping(value = "test",method = RequestMethod.GET)
    @HystrixCommand
    public String test(String word) {
        log.info("test {}", word);
        return "test " + word;
    }

    @ApiOperation(value="测试", notes="测试Get方法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "word",value = "get word",required = true,dataType = "String")
    })
    @RequestMapping(value = "get",method = RequestMethod.GET)
    @HystrixCommand
    public String get(String word) {
        log.info("get {}", word);
        return "get " + word;
    }

    @ApiOperation(value="测试配置", notes="测试配置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "word",value = "get word",required = true,dataType = "String")
    })
    @RequestMapping(value = "testConfig",method = RequestMethod.GET)
    @HystrixCommand
    public String testConfig(String word) {
        log.info("test value: {}", value);
        return "get " + word;
    }
}
