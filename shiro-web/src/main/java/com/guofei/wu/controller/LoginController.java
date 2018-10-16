package com.guofei.wu.controller;

import com.guofei.wu.vo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 吴国飞 (guofei.wu@ucarinc.com)
 * @author 吴国飞 (guofei.wu@ucarinc.com)
 * @version 2018/10/15
 * @since 2018/10/15
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/subLogin", method = RequestMethod.POST)
    @ResponseBody
    public String subLogin(User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return e.getMessage();
        }
        return "login success";
    }


    @RequiresRoles("admin")
    @RequestMapping(value = "/testRoles", method = RequestMethod.GET)
    @ResponseBody
    public String testRoles() {
        return "test roles success";
    }

    @RequiresPermissions(value = {"delete"})
    @RequestMapping(value = "/testPermissions", method = RequestMethod.GET)
    @ResponseBody
    public String testPermissions() {
        return "test permissions success";
    }


}
