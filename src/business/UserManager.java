package src.business;

import src.dao.UserDao;
import src.entity.User;

public class UserManager {
   private final UserDao userDao;

    public UserManager() {
        this.userDao = new UserDao();
    }
    public User findByLogin (String username, String password){
        return this.userDao.findByLogin(username,password);

    }
}
