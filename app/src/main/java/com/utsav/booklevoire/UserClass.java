package com.utsav.booklevoire;

public class UserClass {
    private String email;
    private String password;

    public UserClass(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and setters
    // You can generate these using your IDE or write them manually

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

