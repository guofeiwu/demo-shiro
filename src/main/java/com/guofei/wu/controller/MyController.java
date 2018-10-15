package com.guofei.wu.controller;

import com.guofei.wu.config.PropertiesConfig;
import com.guofei.wu.config.PropertiesListenerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 吴国飞 (guofei.wu@ucarinc.com)
 * @author 吴国飞 (guofei.wu@ucarinc.com)
 * @version 2018/9/30
 * @since 2018/9/30
 */
@RestController
@RequestMapping(value = "/my")
//@ConfigurationProperties(prefix = "my")
public class MyController {

    //    @Value("${my.name}")
    private String name;
    //    @Value("${my.old}")
    private int old;


    @Autowired
    private PropertiesConfig config;

    @RequestMapping(value = "/test2")
    public String test2() {
        return "this is test2";
    }

    @RequestMapping(value = "/test3")
    public String test3() {
        return "my name is " + name + "---" + old;
    }

    @RequestMapping(value = "/test4")
    public String test4() {
        return "my name is " + config.getName();
    }


    @Autowired
    private Environment env;

    @RequestMapping(value = "/test5")
    public String test5() {
        return "my name is " + env.getProperty("my.name") + " --" + env.getProperty("my.old");
    }

    @RequestMapping("/test6")
    public Map<String, Object> test6() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.putAll(PropertiesListenerConfig.getAllProperty());
        return map;
    }


    /**
     * 集成测试
     *
     * @return
     * @since 2018/10/8
     */

    @RequestMapping(value = "/integration/{name}", method = RequestMethod.GET)
    public String integrationTest(@PathVariable String name) {
        return "name:" + name;
    }

}
