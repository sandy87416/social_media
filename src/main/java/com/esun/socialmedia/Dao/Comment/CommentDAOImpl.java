package com.esun.socialmedia.Dao.Comment;

import com.esun.socialmedia.Bean.Comment;
import com.esun.socialmedia.Bean.Post;
import com.esun.socialmedia.DBConnection.DBConnection;
import com.esun.socialmedia.DBConnection.DBConnectionImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO {
    final private DBConnection dbConnection = new DBConnectionImpl();

    @Override
    public List<Comment> getComment(int postID){
        Connection connection = dbConnection.getConnection();
        List<Comment> commentList = new ArrayList<>();
        try {
            String GET_COMMENT  = "SELECT * FROM comment WHERE post_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(GET_COMMENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Comment comment = new Comment(resultSet.getInt("comment_id"));
                comment.setUserID(resultSet.getString("user_id"));
                comment.setContent(resultSet.getString("content"));
                comment.setCreateAt(resultSet.getString("create_at"));
                comment.setUserID(resultSet.getString("user_id"));
                commentList.add(comment);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentList;
    }

    @Override
    public void createComment(Comment comment){
        Connection connection = dbConnection.getConnection();
        String INSERT_COMMENT = "INSERT INTO post (user_id, post_id, content, create_at) values(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMMENT))
        {
            preparedStatement.setString(1, comment.getUserID());
            preparedStatement.setInt(2, comment.getPostID());
            preparedStatement.setString(3, comment.getContent());
            preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
