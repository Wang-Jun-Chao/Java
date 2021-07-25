package com.wjc.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *
 * </pre>
 * Author: 王俊超
 * Date: 2021-07-25 17:54
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String add() {
        return "hello spring security";
    }
}
