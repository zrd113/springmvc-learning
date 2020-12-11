package org.zrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zrd.model.MyClass;
import org.zrd.service.HelloService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author zrd
 * @Date 2020/12/11
 */
@org.springframework.stereotype.Controller
public class MyController {

//    controller一般放在springmvc容器中，其余的放在spring容器中，spring容器是父容器，springmvc容器是子容器，子容器的内容可以访问父容器
    @Autowired
    HelloService helloService;

    @RequestMapping(value = {"/hello", "/hello1"}, method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        System.out.println(helloService.hello("zrd"));
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("name", "zrd");
        return mv;
    }

    @RequestMapping("/hello2")
    public void hello2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/hello.jsp").forward(req, resp);
    }

    //注意这里重定向不能访问WEB-INF中的资源
    @RequestMapping("/hello3")
    public void hello3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/jsp/hello3.jsp");
    }

    @RequestMapping("/hello4")
    public void hello4(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write("hello zrd");
        out.flush();
        out.close();
    }

    @RequestMapping("/hello5")
    public String hello5(Model model) {
        model.addAttribute("name", "zrd");
        return "hello";
    }

    @RequestMapping("/hello6")
    public String hello6() {
        return "forward:/jsp/hello3.jsp";
    }

    @RequestMapping("/hello7")
    public String hello7() {
        return "redirect:/jsp/hello3.jsp";
    }

    @RequestMapping("/hello8")
    //@ResponseBody表示返回值就是要展示出来的值
    @ResponseBody
    public String hello8() {
        return "张瑞达";
    }

    //返回中文字符会乱码
    @RequestMapping(value = "/hello9", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String hello9() {
        return "张瑞达";
    }

    @RequestMapping("/book")
    public String book() {
        return "book";
    }

    @RequestMapping(value = "/doAdd", method = RequestMethod.POST)
    //该方法不需要返回值，也要加@ResponseBody表示不用再去查找相关视图了
    @ResponseBody
    //只要加了@RequestParam，参数默认必填
    public void doAdd(@RequestParam(value = "name", required = true, defaultValue = "张瑞达") String bookname, String author, Double price, Boolean ispublic) {
        System.out.println(bookname);
        System.out.println(author);
        System.out.println(price);
        System.out.println(ispublic);
    }

    @RequestMapping("/class")
    public String clazz() {
        return "myclass";
    }

    @RequestMapping(value = "/addclass", method = RequestMethod.POST)
    @ResponseBody
    public void addClass(MyClass myClass) {
        System.out.println(myClass);
    }

}
