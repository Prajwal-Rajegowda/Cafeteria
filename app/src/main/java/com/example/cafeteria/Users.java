package com.example.cafeteria;

public class Users {
    String email;
    String name;
    String usn;

    public Users(){};
    public Users(String email, String name,String usn)
    {
        this.email = email;
        this.name = name;
        this.usn = usn;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String courseDuration) {
        this.usn = usn;
    }
}
