package com.esun.socialmedia.Dao.User;

import com.esun.socialmedia.Bean.User;

public interface UserDAO {
    public User getUser(String uerID);

    public void createUser(User user);

    public void deleteUser(String uerID);
}
