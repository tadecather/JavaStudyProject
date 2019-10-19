package com.taaaaad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Desc 控制器的类
 * @Author taaaaad
 */
@Controller
@RequestMapping(path="/User")
public class HelloController {

    @RequestMapping(path="/hello")
    public String sayHello(){
        System.out.println("Hello SpringMVC");
        return "success";
    }

    /**
     * 测试 RequestMapping 注解
     * method 请求类型
     * param  请求参数限制 参数存在或者参数和值完全一样
     * @return
     */
    @RequestMapping(value="testRequestMapping", params = {"username=haha"}, headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解");
        return "success";
    }
}
