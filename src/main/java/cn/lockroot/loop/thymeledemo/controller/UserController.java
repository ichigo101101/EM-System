package cn.lockroot.loop.thymeledemo.controller;
import cn.lockroot.loop.thymeledemo.utils.VerifyCodeUtils;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
@RequestMapping("user")
public class UserController {

    private  static final Logger log = LoggerFactory.getILoggerFactory.getLogger(UserController.class);

    @RequestMapping("register")
    public String register(User user,String code,HttpSession session){
        log.debug("用户名:{},真实姓名:{},密码:{},性别:{},",user.getUsername(),user.getRealname(),user.getPassword(),user.getGender());
        log.debug("用户输入验证码:{}",code);

        String sessionCode = session.getAttribute("code").toString();
        if(sessionCode.equalsIgnoreCase(code)){

        }
        return "";
    }
    @RequestMapping("generateImageCode")
    public void generateImageCode(HttpSession session, HttpServletResponse response)throws IOException {
        String code = VerifyCodeUtils.generateVerifyCode(4);
        session.setAttribute( "code",code);
        response.setContentType("image/png");
        ServletOutputStream os= response.getOutputStream() ;
        VerifyCodeUtils.outputImage(  220, 60,os,code) ;

    }

}
