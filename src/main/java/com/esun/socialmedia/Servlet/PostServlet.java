package com.esun.socialmedia.Servlet;

import com.esun.socialmedia.Bean.Post;
import com.esun.socialmedia.Service.LoginService;
import com.esun.socialmedia.Service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PostServlet extends HttpServlet {

    @GetMapping("/post")
    public Post getPost(@PathParam("postID") int postID){
        PostService postService = new PostService();
        return postService.getPost(postID);
    }

    @GetMapping("/postPage")
    public List<Post> getAllPost(){
        PostService postService = new PostService();
        return postService.getAllPost();
    }

}

