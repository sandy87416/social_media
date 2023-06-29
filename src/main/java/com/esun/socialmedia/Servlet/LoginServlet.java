package com.esun.socialmedia.Servlet;

import com.esun.socialmedia.Bean.Post;
import com.esun.socialmedia.Service.LoginService;
import com.esun.socialmedia.Service.PostService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class LoginServlet extends HttpServlet {
    @RequestMapping("/")
    public String main(HttpSession session){
        return "Home Page";
    }

    @GetMapping("/login")
    public String login(HttpSession session, @RequestParam String userID, @RequestParam String password){
        LoginService loginService = new LoginService();
        boolean result = loginService.login(session, userID, password);
        if(result)  return "登入成功";
        return "登入失敗";
    }

}

