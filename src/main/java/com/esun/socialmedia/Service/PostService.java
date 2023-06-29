package com.esun.socialmedia.Service;

import com.esun.socialmedia.Bean.Post;
import com.esun.socialmedia.Dao.Post.*;

import java.util.List;

public class PostService {
    private PostDAO postDAO = new PostDaoImpl();

    public List<Post> getAllPost(){
        return postDAO.getPost();
    }

}
