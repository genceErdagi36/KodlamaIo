package business.concrates;

import business.abstracts.UserService;
import core.AuthService;
import core.EmailService;
import dataAccess.abstracts.UserDao;
import entities.concrates.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceManager implements UserService {
    private final EmailService emailService;
    private final UserDao userDao;
    private final AuthService authService;
    public UserServiceManager(EmailService emailService, UserDao userDao, AuthService authService) {
        this.emailService = emailService;
        this.userDao = userDao;
        this.authService = authService;
    }

    @Override
    public void add(User user, List<User> userList) {
        if (user.getPassword().length() < 6) {
            return;
        }
        Pattern p = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$*");
        Matcher m = p.matcher(user.getEmail());
        if (m.find()) {
            return;
        }
        for (User n_user : userList) {
            if (n_user.getEmail().equals(user.getEmail())) {
                return;
            }
        }
        if(user.getFirstName().length()<2||user.getLastName().length()<2){
            return;
        }
        user.setVerificationCode(/*Random String generation*/"");
        this.emailService.sendEmailVerification(user.getEmail(),user.getVerificationCode());
    }

    //Doğrulama linkine tıklanmış simülasyonu
    public void verification(User user,String verificationCode){
        if(verificationCode.equals(user.getVerificationCode())){
            user.setVerification(true);
            userDao.add(user);
        }
        else{
            System.out.println("User validation Failed");
        }
    }
}
