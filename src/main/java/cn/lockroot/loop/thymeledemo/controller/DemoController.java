package cn.lockroot.loop.thymeledemo.controller;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("demo")
public class DemoController {
    private static final Logger log = LoggerFactory.getLogger(DemoController.class);
    @RequestMapping("demo")
    public String demo(Model model){

        model.addAttribute("msg","hello thymeleaf");
        return  "demo";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("register")
    public String register(){
        return "regist";
    }
}
