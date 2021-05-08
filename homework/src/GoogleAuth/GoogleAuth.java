package GoogleAuth;

public class GoogleAuth {
    public void auth(String email,String password){
        if(email.contains("@")||password.length()>6){
            System.out.println("Kullanıcı Google ile giriş yaptı");
        }else{
            System.out.println("Kullanıcı hatalı");
        }
    }
}
