
public class User {
    public String fullName;
    public String accountName;
    public String email;
    public String password;
    public User(String fullName,String accountName,String email,String password){
        this.fullName=fullName;
        this.accountName=accountName;
        this.email=email;
        this.password=password;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName ) {
        this.accountName =accountName ;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email =email ;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password =password ;
    }
}
