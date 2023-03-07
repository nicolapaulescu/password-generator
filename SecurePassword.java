import java.nio.charset.StandardCharsets;

public class SecurePassword implements PasswordSecurity{
    private String hashedPassword;

    @Override
    public boolean checkPasswordStrength(String input) {
        // Implement your own password strength checker
        // For example, check if the password is at least 8 characters long, contains at least one number and one special character
        return input.length() >= 8 && input.matches(".*\\d.*");
    }


}
