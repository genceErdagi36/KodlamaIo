package core;

import GoogleAuth.GoogleAuth;

public class GoogleAuthServiceAdapter implements AuthService{
    GoogleAuth googleAuth = new GoogleAuth();
    @Override
    public void login(String email, String password) {
        googleAuth.auth(email,password);
    }
}
