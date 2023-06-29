package com.esun.socialmedia.Dao.Comment;

import com.esun.socialmedia.Bean.Comment;

import java.util.List;

public interface CommentDAO {

    public List<Comment> getComment(int postID);
    public void createComment(Comment comment);

}
