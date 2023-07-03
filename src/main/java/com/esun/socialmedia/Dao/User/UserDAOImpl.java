package com.esun.socialmedia.Dao.User;

import com.esun.socialmedia.Bean.User;
import com.esun.socialmedia.DBConnection.DBConnection;
import com.esun.socialmedia.DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    @Override
    public User getUser(String userID) {
        Connection connection = dbConnection.getConnection();
        User user = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE user_id = ?");
            preparedStatement.setString(1, userID);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = new User(userID);
            user.setPassword(resultSet.getString("password"));
            user.setUserName(resultSet.getString("user_name"));
            user.setBiography(resultSet.getString("biography"));
            user.setCoverImage(resultSet.getString("cover_image"));
            user.setEmail(resultSet.getString("email"));

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void createUser(User user){
        Connection connection = dbConnection.getConnection();
        String INSERT_USER = "INSERT INTO user (user_id, user_name, email, password, cover_image, biography) values(?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER))
        {
            preparedStatement.setString(1, user.getUserID());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getCoverImage());
            preparedStatement.setString(6, user.getBiography());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String userID) {
        Connection connection = dbConnection.getConnection();
        String DELETE_USER = "DELETE FROM user WHERE user_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER))
        {
            preparedStatement.setString(1, userID);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
