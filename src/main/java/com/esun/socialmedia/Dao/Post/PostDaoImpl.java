package com.esun.socialmedia.Dao.Post;

import com.esun.socialmedia.Bean.Post;
import com.esun.socialmedia.DBConnection.DBConnection;
import com.esun.socialmedia.DBConnection.DBConnectionImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImpl implements PostDAO {
    final private DBConnection dbConnection = new DBConnectionImpl();

    public List<Post> getPost(){
        Connection connection = dbConnection.getConnection();
        List<Post> postList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM post");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Post post = new Post(resultSet.getInt("post_id"));
                post.setUserID(resultSet.getString("user_id"));
                post.setContent(resultSet.getString("content"));
                post.setCreateAt(resultSet.getString("create_at"));
                post.setUserID(resultSet.getString("user_id"));
                postList.add(post);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }
    public List<Post> getPostByUserID(String userID){
        Connection connection = dbConnection.getConnection();
        List<Post> postList = new ArrayList<>();
        String GET_USER_POST = "SELECT * FROM post WHERE user_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_POST)){
            preparedStatement.setString(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Post post = new Post(resultSet.getInt("post_id"));
                post.setUserID(resultSet.getString("user_id"));
                post.setContent(resultSet.getString("content"));
                post.setCreateAt(resultSet.getString("create_at"));
                post.setUserID(resultSet.getString("user_id"));
                postList.add(post);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    public void createPost(Post post){
        Connection connection = dbConnection.getConnection();
        String INSERT_POST = "INSERT INTO post (user_id, content, image, create_at) values(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_POST))
        {
            preparedStatement.setString(1, post.getUserID());
            preparedStatement.setString(2, post.getContent());
            preparedStatement.setString(3, post.getImage());
            preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePost(int postID, String content, String image) {
        Connection connection = dbConnection.getConnection();
        String UPDATE_POST = "UPDATE post SET content=?, image=? WHERE post_id =?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_POST))
        {
            preparedStatement.setString(1, content);
            preparedStatement.setString(2, image);
            preparedStatement.setInt(3, postID);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePost(int postID, String userID){
        Connection connection = dbConnection.getConnection();
        String DELETE_PROJECT = "DELETE FROM reward_project WHERE post_id = ? AND user_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PROJECT))
        {
            preparedStatement.setInt(1, postID);
            preparedStatement.setString(2, userID);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
