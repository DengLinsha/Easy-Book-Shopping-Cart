package loginSession;

public class User {
    public String username;
    public String password;
    public String freeStatus;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public  String getFreeStatus() { return freeStatus; }
    public void setFreeStatus(String freeStatus) { this.freeStatus = freeStatus;}

}
