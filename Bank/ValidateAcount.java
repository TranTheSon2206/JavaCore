package Bank;

public class ValidateAcount {
    public final String MOBILE = "0912744955";
    public final String PASSWORD = "TRAN THE SON";
    public boolean checkAcount(String mobile, String password) {
        if (mobile.equals(MOBILE)) {
            if (password.equals(PASSWORD)) {
                System.out.println("Login successful");
                return true;
            } else {
                System.out.println("Login failed");
                return false;
            }
        }else {
            System.out.println("Please check your password or mobile number");
            return false;
        }
    }
}
