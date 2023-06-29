package com.esun.socialmedia.Service;

import com.esun.socialmedia.Bean.User;
import com.esun.socialmedia.Dao.User.UserDAO;
import com.esun.socialmedia.Dao.User.UserDAOImpl;

import javax.servlet.http.HttpSession;

public class LoginService{
    private UserDAO userDAO = new UserDAOImpl();

    public boolean login(HttpSession session, String userID, String password) {
        User user = userDAO.getUser(userID, password);
        if(user != null) {
            session.setAttribute("userID", userID);
            session.setAttribute("UserName", user.getUserName());
            return true;
        }
        return false;
    }
}
