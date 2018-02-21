package model;

import exceptions.InvalidInputDataException;
import model.helper.PasswordHelper;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.regex.Pattern;

public class User{
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

    public User(){}
    public User(String username, String password, String confirmPass, String dob, String phoneNumber, String email)
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
            throws InvalidInputDataException{
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

    public static Map<String, Object> registerUser(
            String username,
            String password,
            String confirmPass,
            String dob,
            String phoneNumber,
            String email,
            Connection connection)throws InvalidInputDataException{
        Map<String, Object> results = new HashMap<>();
        User user = new User(username, password, confirmPass, dob, phoneNumber, email);
        results.put("user", user);
        PreparedStatement newUser;
        String sql = "INSERT INTO users (username, email, password, phone_number, dob) values (?, ?, ?, ?, ?);";
        try {
            connection.setAutoCommit(false);
            newUser = connection.prepareStatement(sql);
            newUser.setString(1, user.getUsername());
            newUser.setString(2, user.getEmail());
            newUser.setString(3, PasswordHelper.hashPassword(user.getPassword()));
            newUser.setString(4, user.getPhoneNumber());
            newUser.setDate(5, Date.valueOf(user.getDob()));
            newUser.execute();
            connection.commit();
            results.put("success", true);
            return results;
        } catch (SQLException e) {
            e.printStackTrace();
            results.put("error", e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        results.put("success", false);
        return results;

    }

    public static Map<String, Object> getUser(String identifier, String actualPass, Connection connection) {
        Map<String, Object> results = new HashMap<>();
        results.put("success", false);
        results.put("error", "Invalid username or email");
        PreparedStatement gUser;
        boolean useEmail = true;
        if(!VALID_EMAIL.matcher(identifier).matches()){
            if(!VALID_UN.matcher(identifier).matches()){
                return results;
            }else{
                useEmail = false;
            }
        }
        String whereTo = useEmail?"email":"username";
        String sql = "SELECT " + whereTo + ", password, phone_number, " + (useEmail?"username":"email")+ " FROM users WHERE " + whereTo + " = ?;";
        try {
            gUser = connection.prepareStatement(sql);
            gUser.setString(1, identifier);
            ResultSet set = gUser.executeQuery();
            if (set.next()){
                String password = set.getString("password");
                if(PasswordHelper.checkPassword(actualPass, password)){
                    results.put("success", true);
                    results.put("username", set.getString("username"));
                    results.put("email", set.getString("email"));
                    results.put("phoneNumber", set.getString("phone_number"));
                }else{
                    results.put("error", "Invalid " + whereTo + " or password");
                }
            }
        } catch (Exception e) {
            results.clear();
            results.put("success", false);
            results.put("error", e.getMessage());
            e.printStackTrace();
        }
        return results;
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
