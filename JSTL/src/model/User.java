package model;

import java.util.Random;

public class User {
    private String username;
    private String password;
    private String dob;
    private String phoneNumber;
    private String email;
    public User(){}
    public User(String username, String password, String dob, String phoneNumber, String email) {

        this.username = username;
        this.password = password;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public String generateSalt(int length, boolean number) {
        final String SALTCHARS = number?"1234567890":"ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();

    }
    @Override
    public String toString() {
        return "UserDAO: {" + "\n"
                + " username: " + username + ",\n"
                + " password: " + password + ",\n"
                + " dob: " + dob + ",\n"
                + " phone: " + phoneNumber + ",\n"
                + " email: " + email + "\n"
                + "}";
    }
}
