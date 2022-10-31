package com.example.productcode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author julu
 * @date 2022/9/24 14:06
 */
@RestController
@RequestMapping("/product")
public class QrCodeProductController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String Test(){
        return "helloWorld";
    }


}
