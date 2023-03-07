import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordTest {

    @Test
    public void testPasswordGenerator() {
        Password password = new Password();

        // Test the length of the generated password
        String generatedPassword = password.PasswordGenerator();
        assertTrue(generatedPassword.length() == 10);

        // Test that the generated password contains at least one uppercase letter, one lowercase letter, and one number
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasNumber = false;
        for (char c : generatedPassword.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            }
        }
        assertTrue(hasUpper && hasLower && hasNumber);
    }
}
