package com.esun.socialmedia.Dao.Comment;

import com.esun.socialmedia.Bean.Post;

import java.util.List;

public interface PostDAO {

    public List<Post> getPost();
    public List<Post> getPostByUserID(String userID);
    public void createPost(Post post);
    public void updatePost(int postID, String content, String image);
    public void deletePost(int postID, String userID);

}
