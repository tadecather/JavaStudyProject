package com.taaaaad.controller;

import com.taaaaad.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws SysException{
        System.out.println("testException 执行了");

        // 模拟异常
        try {
            int a = 10 / 0;
        } catch (Exception e){
            // 打印异常信息
            e.printStackTrace();
            // 抛出自定义异常
            throw new SysException("查询所有用户出现错误");
        }

        return "success";
    }
}
