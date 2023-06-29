package com.esun.socialmedia.Service;

import com.esun.socialmedia.Bean.Comment;
import com.esun.socialmedia.Dao.Comment.CommentDAO;
import com.esun.socialmedia.Dao.Comment.CommentDAOImpl;

import java.util.List;

public class CommentService {
    private CommentDAO commentDAO = new CommentDAOImpl();

    public List<Comment> getComment(int postID) {
        return commentDAO.getComment(postID);
    }
}
