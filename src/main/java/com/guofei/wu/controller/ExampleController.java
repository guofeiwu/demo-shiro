package com.guofei.wu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 吴国飞 (guofei.wu)
 * @author 吴国飞 (guofei.wu)
 * @version 2018/9/28
 * @since 2018/9/28
 */

@Controller
@RequestMapping(value = "/example")
public class ExampleController {
    Logger logger = LoggerFactory.getLogger(ExampleController.class);

    @RequestMapping(value = "/test1")
    public String test1() {
        return "example/success";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "example/login";
    }
}
