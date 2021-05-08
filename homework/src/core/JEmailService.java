package core;

public class JEmailService implements EmailService{
    @Override
    public void sendEmailVerification(String email, String verificationCode) {
        System.out.println("Email Gönderildi");
    }
}
