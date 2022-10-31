package com.example.sentineldemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author julu
 * @date 2022/10/31 23:29
 */
@Controller
@RequestMapping("/sentinel")
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test(){
        System.out.println("123456");
    }
}
