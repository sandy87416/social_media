package com.esun.socialmedia.Servlet;

import com.esun.socialmedia.Service.LoginService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@RestController
public class LoginServlet extends HttpServlet {
    @RequestMapping("/")
    public String hello(HttpSession session){
        return login(session);
    }

    @GetMapping("/login")
    public String login(HttpSession session){
        LoginService loginService = new LoginService();
        boolean result = loginService.login(session, "sandy123", "123");
        if(result)  return "登入成功";
        return "登入失敗";
    }
}

