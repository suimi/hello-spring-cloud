/*
 * Copyright (c) 2013-2015, 成都中联信通科技股份有限公司
 * Created by lichengcai on 2016-12-27.
 */
package com.suimi.hello.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @HystrixCommand
    public String hello(String word) {
        log.info("hello {}", word);
        return "hello " + word;
    }

    @HystrixCommand
    @RequestMapping(value = "add/{a}/{b}", method = RequestMethod.GET)
    public int add(@PathVariable("a") int a, @PathVariable("b") int b) {
        log.info("add {} and {}", a, b);
        return a + b;
    }
}
