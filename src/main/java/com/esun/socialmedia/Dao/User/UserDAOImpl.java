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
    public User getUser(String userID, String password) {

        Connection connection = dbConnection.getConnection();
        User user = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE user_id = ? AND password = ?");
            preparedStatement.setString(1, userID);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = new User(userID, password);
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

}
