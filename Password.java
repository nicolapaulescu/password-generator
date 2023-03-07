import java.security.SecureRandom;
public class Password {
    public String PasswordGenerator() {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!?";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        int pswd_lnth=10;
        for (int i = 0; i < pswd_lnth; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }

}
