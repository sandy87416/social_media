package com.esun.socialmedia.Service;

import com.esun.socialmedia.Bean.User;
import com.esun.socialmedia.Dao.User.UserDAO;
import com.esun.socialmedia.Dao.User.UserDAOImpl;

import javax.servlet.http.HttpSession;

public class LoginService{
    private UserDAO userDAO = new UserDAOImpl();

    public boolean login(HttpSession session, String user_id, String password) {
        User user = userDAO.getUser(user_id, password);
        if(user != null) {
            session.setAttribute("user_id", user_id);
            session.setAttribute("user_name", user.getUserName());
            return true;
        }
        return false;
    }
}
