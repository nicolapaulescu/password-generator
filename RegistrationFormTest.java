import org.junit.Test;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
public class RegistrationFormTest {
    @Test
    public void testRegistrationForm() {
        List<String> values = new ArrayList<>();
        values.add("John Doe");
        values.add("johndoe");
        values.add("johndoe@example.com");
        values.add("password123");
        JFrame parent = new JFrame();
        RegistrationForm registrationForm = new RegistrationForm(parent);
        for (int i = 0; i < values.size(); i++) {
            if(i == 0) {
                registrationForm.FullNameTextField.setText(values.get(i));
            } else if(i == 1) {
                registrationForm.AccountNameTextField.setText(values.get(i));
            } else if(i == 2) {
                registrationForm.EmailTextF.setText(values.get(i));
            } else {
                registrationForm.passwordField1.setText(values.get(i));
            }
        }
        registrationForm.registrateButton.doClick();
        assertTrue(registrationForm.dataInsertedSuccessfully);
    }
}
