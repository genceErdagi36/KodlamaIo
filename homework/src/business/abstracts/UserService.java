package business.abstracts;

import entities.concrates.User;

import java.util.List;

public interface UserService {
    void add(User user,List<User> userList);
}
