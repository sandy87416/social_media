package com.esun.socialmedia.Service;

import com.esun.socialmedia.Bean.User;
import com.esun.socialmedia.Dao.User.UserDAO;
import com.esun.socialmedia.Dao.User.UserDAOImpl;
import com.esun.socialmedia.Utils.AES;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpSession;

public class LoginService{
    final private UserDAO userDAO = new UserDAOImpl();

    public boolean login(String userID, String password) {
        User user = userDAO.getUser(userID);
        String decryptedPassword = AES.decrypt(user.getPassword());
        return password.equals(decryptedPassword);
    }

    public User register(JSONObject json) {
        User user;
        try {
            String password = json.getString("password");
            String encryptedPassword = AES.encrypt(password);

            user = new User(json.getString("userID"));
            user.setPassword(encryptedPassword);
            user.setBiography(json.optString("biography"));
            user.setEmail(json.optString("email"));
            user.setCoverImage(json.optString("coverImage"));

            userDAO.createUser(user);

        } catch (JSONException e) {
            return null;
        }
        return user;
    }
}
