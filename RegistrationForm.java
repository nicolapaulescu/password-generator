import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegistrationForm extends JDialog{
    public boolean dataInsertedSuccessfully;
    private JPanel Jpanel;
    private JLabel FullNameLabel;
    JTextField FullNameTextField;
    private JLabel AccountNameLabel;
    JTextField AccountNameTextField;
    private JLabel EmailLabel;
    JTextField EmailTextF;
    private JLabel Passwordlabel;
    JPasswordField passwordField1;
    private JButton generatePasswordButton;
    private JButton seePasswordButton;
    JButton registrateButton;

    public RegistrationForm(JFrame parent) {

            super(parent);
            setTitle("Create a new account");
            setContentPane(Jpanel);
            setMinimumSize(new Dimension(450, 474));
            //setLocationRelativeTo(parent);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            passwordGenerator = new Password();
        registrateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String fullName= FullNameTextField.getText();
                if(fullName!=null){
                    System.out.println(fullName);
                }else{
                    System.out.println("ahhh");
                }
                String accountName= AccountNameTextField.getText();
                String email=EmailTextF.getText();
                String password=String.valueOf(passwordField1.getPassword());
                User user1=new User(fullName,accountName,email,password);
                if (fullName.isEmpty() || email.isEmpty() || accountName.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(parent,
                            "Please enter all fields",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                final String DB_URL = "jdbc:mysql://localhost:3306/jdbc-p3";
                final String USERNAME = "root";
                final String PASSWORD = "mbefaoju";
                try{
                    List<String> values = new ArrayList<>();
                    values.add(user1.fullName);
                    values.add(user1.accountName);
                    values.add(user1.email);
                    values.add(user1.password);
                    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    String sql="INSERT INTO users0(FullName,AccountName,Email,Password) VALUES(?,?,?,?)" ;
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    for (int i = 0; i < values.size(); i++) {
                        preparedStatement.setString(i+1, values.get(i));
                    }
                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Data inserted successfully!");
                    } else {
                        System.out.println("Error inserting data.");
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }

                }catch(Exception a){
                    // Print the exception message
                    System.out.println("Error: " + a.getMessage());

                    // Print the SQL statement
                    String sql="INSERT INTO users0(FullName,AccountName,Email,Password) VALUES(?,?,?,?)" ;
                    System.out.println("SQL statement: " + sql);


                    a.printStackTrace();
                    a.printStackTrace();
                    System.out.println("aolooo");
                }
                if (user1!=null) {
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(parent,
                            "Failed to register new user",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        );
        generatePasswordButton.addActionListener(e -> {
            SecurePassword securePassword= new SecurePassword();
            String ps = passwordGenerator.PasswordGenerator();
            if(securePassword.checkPasswordStrength(ps)){

            }else{
                JOptionPane.showMessageDialog(parent,
                        "Password not secure",
                        "You can try to generate the password again",
                        JOptionPane.ERROR_MESSAGE);
            }
            passwordField1.setText(ps);
        });
        seePasswordButton.addActionListener(new ActionListener() {
            private boolean visible=true;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(this.visible) {
                    seePasswordButton.setForeground(Color.GREEN);
                    passwordField1.setEchoChar((char)0);
                    this.visible=false;
                } else {
                    this.visible=true;
                    seePasswordButton.setForeground(Color.RED);
                    passwordField1.setEchoChar('*');
                }
            }
        });
        setVisible(true);
    }
    public Password passwordGenerator;
    public User user;

    public static void main(String[] arg){
        RegistrationForm form=new RegistrationForm(null);

        User user= form.user;
        if (user != null) {
            System.out.println("You have been successfully registered! ^^");
        }
        else {
            System.out.println("You have not been registered ,try again! ):");
        }

    }
}
