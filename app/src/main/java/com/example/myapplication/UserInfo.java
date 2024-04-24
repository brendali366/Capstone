package com.example.myapplication;

public class UserInfo {
    private String email;
    private String username;

    public UserInfo() {
        // Default constructor required for Firebase
    }

    public UserInfo(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    // Add setters if needed
}


/*
public class UserInfo {
    private String username;

    public UserInfo() {

    }
    public UserInfo(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}
*/
