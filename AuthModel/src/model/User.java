package model;

import exceptions.InvalidInputDataException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

public class User {
    private String username;
    private String password;
    private String dob;
    private String phoneNumber;
    private String email;

    private static final Pattern VALID_EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_PN = Pattern.compile("^0\\d{8,9}$");
    private static final Pattern VALID_UN = Pattern.compile("[a-zA-Z][a-zA-Z0-9]{5,31}");
    private static final Pattern VALID_PS = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W]).{8,64})");
    private static boolean checkDOB(String dob){
        Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        try {
            cal.setTime(Date.valueOf(dob));
            cal.getTime();
        }
        catch (Exception e) {
            System.out.println("Invalid date");
            return false;
        }
        return true;
    }

    public User(
            String username,
            String password,
            String confirmPass,
            String dob,
            String phoneNumber,
            String email)
    throws InvalidInputDataException
    {
        validator(username, password, confirmPass, dob, phoneNumber, email);
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    private void validator(String username, String password, String confirmPass, String dob, String phoneNumber, String email)
            throws InvalidInputDataException {
        List<String> error = new ArrayList<>();
        if(!VALID_UN.matcher(username).matches())
            error.add("Username is Invalid");
        if (!password.equals(confirmPass))
            error.add("Password Does Not Match");
        else if (!VALID_PS.matcher(password).matches())
            error.add("Password must contains capital, small, number and a special character with the minimum of 8 and maximum of 33");
        if (!checkDOB(dob))
            error.add("Invalid Date of Birth");
        if (!VALID_EMAIL.matcher(email).matches())
            error.add("Invalid Email Address");
        if (!VALID_PN.matcher(phoneNumber).matches())
            error.add("Invalid Phone Number");
        if(!error.isEmpty())
            throw new InvalidInputDataException(error);

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

    @Override
    public String toString() {
        return "User: {" + "\n"
            + " username: " + username + ",\n"
            + " password: " + password + ",\n"
            + " dob: " + dob + ",\n"
            + " phone: " + phoneNumber + ",\n"
            + " email: " + email + "\n"
            + "}";
    }
}
