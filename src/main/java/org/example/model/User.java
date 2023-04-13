package org.example.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    private String password;
    private String username;
    private String dni;
    private String WP;
    public User() {
    }

    public User(String username,String password,String dni,String WP) {
        this.password = password;
        this.username = username;
        this.dni=dni;
        this.WP=WP;
    }

    public boolean login(String username, String password){
        if(this.password.equals(password) && this.username.equals(username)){
            return true;
        }
        return false;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getDni() {
        return dni;
    }

    public String getWP() {
        return WP;
    }
}
