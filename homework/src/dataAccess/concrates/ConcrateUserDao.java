package dataAccess.concrates;

import dataAccess.abstracts.UserDao;
import entities.concrates.User;

public class ConcrateUserDao implements UserDao {
    @Override
    public void add(User user) {
        System.out.println(user.getId() + "Databaseye eklendi");
    }
}
