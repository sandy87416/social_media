package com.esun.socialmedia.Service;

import com.esun.socialmedia.Bean.Comment;
import com.esun.socialmedia.Bean.Post;
import com.esun.socialmedia.Dao.Post.*;

import java.util.List;

public class PostService {
    private PostDAO postDAO = new PostDAOImpl();

    public List<Post> getAllPost(){
        return postDAO.getPost();
    }

    public Post getPost(int postID) {
        Post post = postDAO.getPostByPostID(postID);
        CommentService commentService = new CommentService();
        List<Comment> commentList = commentService.getComment(postID);
        post.setComment(commentList);
        return post;
    }
}
