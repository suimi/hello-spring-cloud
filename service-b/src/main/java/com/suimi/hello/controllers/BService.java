/*
 * Copyright (c) 2013-2015, 成都中联信通科技股份有限公司
 * Created by lichengcai on 2017-03-31.
 */
package com.suimi.hello.controllers;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BService {
    public int add(int a, int b) {
        log.info("{}+{}", a, b);
        return a + b;
    }
}
