package com.taaaaad.controller;

import com.taaaaad.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ExportException;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 测试字符串,返回一个字符串
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString 执行了");
        // 模拟从数据库中查找出一个对象
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123456");
        user.setAge(20);
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 返回 void
     *      默认值 请求路径的文件名
     *  请求转发是一次请求，不用去编写项目名称
     *  重定向
     * @return
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid 执行了");
        // 编写请求转发程序
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        // 重定向
//        response.sendRedirect(request.getContextPath() + "/index.jsp");
        // 直接响应
        // 设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("Hello" + "你好");
        return;
    }

    /**
     * 测试 ModelAndView
     * @throws Exception
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mv = new ModelAndView();
        // 模拟从数据库中查找出一个对象
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123456");
        user.setAge(20);

        // 把User存到mv 对象中，也会把User 对象存入到 request 域中
        mv.addObject("user", user);

        // 跳转到哪个页面
        mv.setViewName("success");

        return mv;
    }

    /**
     * 测试 关键字进行 转发或者重定向
     * @throws Exception
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect 方法执行了......");

        // 转发
//        return "forward:/WEB-INF/pages/success.jsp";
        // 重定向
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求和输出
     * @throws Exception
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax 方法执行了......");
        // 客户端发送到的是Ajax 请求，传的 json 字符串, 后端把 json 数据已经封装到User 对象
        System.out.println(user);

        // 做响应
        user.setUsername("ax");
        user.setAge(21);

        return user;
    }

}
