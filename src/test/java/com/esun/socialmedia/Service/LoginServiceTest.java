package com.esun.socialmedia.Service;

import com.esun.socialmedia.Bean.User;
import com.esun.socialmedia.Dao.User.UserDAO;
import com.esun.socialmedia.Dao.User.UserDAOImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

    @Test
    void login() {
        LoginService loginService = new LoginService();
        String userID = "testUserID";
        String password = "testUserPassword";
        boolean result = loginService.login(userID, password);
        assertTrue(result);
    }

    @Test
    void register() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("userID", "testUserID");
        json.put("userName", "testUserName");
        json.put("password", "testUserPassword");
        LoginService loginService = new LoginService();
        User user = loginService.register(json);
        assertNotNull(user);
    }

    @After
    void tearDown() {
        UserDAO userDAO = new UserDAOImpl();
        String userID = "testUserID";
        userDAO.deleteUser(userID);
    }
}