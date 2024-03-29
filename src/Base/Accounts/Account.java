package Base.Accounts;

import Base.Units.Course;

import java.util.ArrayList;

public abstract class Account {
    private String userName;
    private String password;
    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
