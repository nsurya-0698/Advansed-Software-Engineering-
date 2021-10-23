package production.business;

import java.util.regex.Pattern;

public class UserAccount {

    private String userName;
    private String password;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public UserAccount() {
    }

    public static String checkInputError(String userName, String password, String firstName, String lastName, String email, String phone) {
        String errorMessage = "";
        if (!isUserNameValid(userName))
            errorMessage += "Invalid user name.\n";
        if (!isPasswordValid(password))
            errorMessage += "Invalid password.\n";
        if (!isFirstNameValid(firstName))
            errorMessage += "Invalid first name.\n";
        if (!isLastNameValid(lastName))
            errorMessage += "Invalid last name.\n";
        if (!isEmailValid(email))
            errorMessage += "Invalid email.\n";
        if (!isPhoneNumberValid(phone))
            errorMessage += "Invalid phone number.\n";
        return errorMessage;
    }

    private static Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z][[a-zA-Z]\\d]*");
    private static Pattern PASSWORD_PATTERN = Pattern
            .compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$^&])[a-zA-Z0-9@#$^&]{6,}$");
    private static Pattern NAME_PATTERN = Pattern.compile("[a-zA-Z]+");
    private static Pattern PHONE_PATTERN = Pattern.compile("^[2-9][\\d]{2}[2-9][\\d]{6}");
    private static Pattern EMAIL_PATTERN = Pattern
            .compile("^[a-zA-Z0-9]+[\\w\\.\\-\\+]*@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}");

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // you need to complete this method; do not change the return type
    public static boolean isUserNameValid(String userName) {
        // check if userName is valid
        return userName != null && USERNAME_PATTERN.matcher(userName).matches();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // you need to complete this method; do not change the return type
    public static boolean isPasswordValid(String password) {
        // check if password is valid
        return password != null && PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean isValidCredential(String userName, String password) {
        return matchUserName(userName) && matchPassword(password);
    }

    public boolean matchUserName(String userName) {
        return userName != null && userName.equalsIgnoreCase(this.userName);
    }

    private boolean matchPassword(String password) {
        return password != null && password.equals(this.password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // you need to complete this method; do not change the return type
    public static boolean isFirstNameValid(String firstName) {
        // check if firstName is valid
        return firstName != null && NAME_PATTERN.matcher(firstName).matches();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // you need to complete this method; do not change the return type
    public static boolean isLastNameValid(String lastName) {
        // check if lastName is valid
        return lastName != null && NAME_PATTERN.matcher(lastName).matches();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // you need to complete this method; do not change the return type
    public static boolean isEmailValid(String email) {
        // check if email is valid
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public String getPhoneNumber() {
        return phone;
    }

    public void setPhoneNumber(String phone) {
        this.phone = phone;
    }

    // you need to complete this method; do not change the return type
    public static boolean isPhoneNumberValid(String phone) {
        return phone != null && PHONE_PATTERN.matcher(phone).matches();
    }
}
