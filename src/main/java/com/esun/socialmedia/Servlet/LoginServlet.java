package com.esun.socialmedia.Servlet;

import com.esun.socialmedia.Bean.Post;
import com.esun.socialmedia.Bean.User;
import com.esun.socialmedia.Service.LoginService;
import com.esun.socialmedia.Service.PostService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class LoginServlet extends HttpServlet {
    @RequestMapping("/")
    public String main(HttpSession session){
        return "Home Page";
    }

    @GetMapping("/login")
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String userID = req.getParameter("userID");
        String password = req.getParameter("password");

        LoginService loginService = new LoginService();
        boolean result = loginService.login(userID, password);
        if(result) {
            session.setAttribute("userID", userID);
            session.setAttribute("userName", req.getParameter("userName"));
            req.getRequestDispatcher("/postPage").forward(req, resp);
        }
        else {
            resp.sendError(404, "登入失敗");
        }
    }

    @GetMapping("/register")
    public void register(HttpServletRequest req, HttpServletResponse resp){
        try {
            String registerJSON = req.getParameter("registerJSON");
            JSONObject json = new JSONObject(registerJSON);

            LoginService loginService = new LoginService();
            User user = loginService.register(json);

            if(!user.equals(null)){
                req.getRequestDispatcher("/postPage").forward(req, resp);
            }
            else{
                resp.sendError(404, "註冊失敗");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

