import business.concrates.UserServiceManager;
import core.GoogleAuthServiceAdapter;
import core.JEmailService;
import dataAccess.concrates.ConcrateUserDao;
import entities.concrates.User;

public class Main {

    public static void main(String[] args) {
        UserServiceManager userServiceManager = new UserServiceManager(new JEmailService(),new ConcrateUserDao(),new GoogleAuthServiceAdapter());
        User user = new User(1,"Gence","Erdağı","gence@mail.com","123456");
        userServiceManager.add(user,null);
    }
}
/*Regex : ^[A-Za-z0-9+_.-]+@(.+)$*/