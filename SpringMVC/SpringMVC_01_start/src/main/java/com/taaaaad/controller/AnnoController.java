package com.taaaaad.controller;

import com.taaaaad.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 常用注解
 */

@Controller
@RequestMapping("anno")
@SessionAttributes(value = {"msg"}) //把msg 存入 session 对象中
public class AnnoController {

    /**
     * RequestParam
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name="name") String username){
        System.out.println("执行了.....");
        System.out.println(username);
        return "success";
    }

    /**
     * RequestBody
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了.....");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable
     * @return
     */
    @RequestMapping(value = "/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name="sid") String id){
        System.out.println("执行了.....");
        System.out.println(id);
        return "success";
    }

    /**
     * RequestHeader
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println("执行了.....");
        System.out.println(header);
        return "success";
    }

    /**
     * CookieValue
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookie){
        System.out.println("执行了.....");
        System.out.println(cookie);
        return "success";
    }

    /**
     * @ModelAttribute
     *  方法上 ： 优先执行
     *
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute 执行了.....");
        System.out.println(user);
        return "success";
    }

    /**
     * 该方法先执行 有返回值

    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser 执行了....");
        // 通过数据库查询数据
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }
    */

    /**
     * 无返回值 需要封装在 Map 中
     * @param uname
     * @param map
     */
    @ModelAttribute
    public void showUser(String uname, Map<String, User> map){
        System.out.println("showUser 执行了....");
        // 通过数据库查询数据
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc", user);
    }


    /**
     * SessionAttributes 注解
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes 执行了....");
        // model 对象会存储在 Request 对象中
        model.addAttribute("msg", "HelloWorld");
        return "success";
    }

    /**
     * 获取值
     * SessionAttributes 注解
     * @return
     */
    @RequestMapping("/testGetSessionAttributes")
    public String testGetSessionAttributes(ModelMap model){
        System.out.println("testGetSessionAttributes 执行了....");
        // model 对象会存储在 Request 对象中
        String msg = (String) model.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除
     * SessionAttributes 注解
     * @return
     */
    @RequestMapping("/testDelSessionAttributes")
    public String testDelSessionAttributes(SessionStatus status){
        System.out.println("testDelSessionAttributes 执行了....");
        status.setComplete();
        return "success";
    }
}
