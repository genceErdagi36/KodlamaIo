package core;

public interface EmailService {
    public void sendEmailVerification(String email, String verificationCode);
}
