package test.acceptancetests;

import junit.framework.TestCase;

import junit.framework.TestCase;
import production.business.UserAccount;
import production.business.UserAccountManager;

public class RegisterNewUserTests extends TestCase{
	
    private UserAccountManager userAccountManager;

    private final String existingUserName = "admin";
    private final String existingPassword = "@Test1";
    private final String existingFirstName = "Scrum";
    private final String existingLastName = "Master";
    private final String existingEmail = "admin@umkc.edu";
    private final String existingPhone = "9132835734";

    private final String testUserName = "jsmith";
    private final String testPassword = "@White0House";
    private final String testFirstName = "John";
    private final String testLastName = "Smith";
    private final String testEmail = "john.smith@gmail.com";
    private final String testPhone = "7024265734";


    protected void setUp() throws Exception {
        super.setUp();
        userAccountManager = new UserAccountManager();
        userAccountManager.registerNewUser(
                existingUserName,
                existingPassword,
                existingPassword,
                existingFirstName,
                existingLastName,
                existingEmail,
                existingPhone);
    }
    protected void setUp() throws Exception {
        super.setUp();
        userAccountManager = new UserAccountManager();
        userAccountManager.registerNewUser(
                existingUserName,
                existingPassword,
                existingPassword,
                existingFirstName,
                existingLastName,
                existingEmail,
                existingPhone);
    }
    public void testSuccessfulRegistration() {
        String registrationResult = userAccountManager.registerNewUser(
                testUserName,
                testPassword,
                testPassword,
                testFirstName,
                testLastName,
                testEmail,
                testPhone
        );
        assertEquals(registrationResult, UserAccountManager.NOINPUTERROR);
        UserAccount userAccount = userAccountManager.login(testUserName, testPassword);
        assertNotNull(userAccount);
        assertTrue(userAccount.getEmail().equalsIgnoreCase(testEmail));
        assertTrue(userAccount.getFirstName().equalsIgnoreCase(testFirstName));
        assertTrue(userAccount.getLastName().equalsIgnoreCase(testLastName));
        assertTrue(userAccount.getEmail().equalsIgnoreCase(testEmail));
        assertTrue(userAccount.getPhoneNumber().equalsIgnoreCase(testPhone));
    }
    public void testRegistrationWithInvalidUserName() {
        String registrationResult = userAccountManager.registerNewUser(
                "Invalid@user_name",
                testPassword,
                testPassword,
                testFirstName,
                testLastName,
                testEmail,
                testPhone
        );
        System.out.println(registrationResult);
        assertTrue(registrationResult.equalsIgnoreCase("Invalid user name.\n"));
        UserAccount userAccount = userAccountManager.login("jsmith", testPassword);
        assertNull(userAccount);
    }
    public void testRegistrationWithAlreadyExistingUser() {
        String registrationResult = userAccountManager.registerNewUser(
                existingUserName,
                testPassword,
                testPassword,
                testFirstName,
                testLastName,
                testEmail,
                testPhone
        );
        System.out.println(registrationResult);
        assertEquals(registrationResult, "User name is not available!");
        UserAccount userAccount = userAccountManager.login(existingUserName, testPassword);
        assertNull(userAccount);
    }
    public void testRegistrationWithIncorrectReEnteredPassword() {
        String registrationResult = userAccountManager.registerNewUser(
                testUserName,
                testPassword,
                testPassword + "123",
                testFirstName,
                testLastName,
                testEmail,
                testPhone
        );
        System.out.println(registrationResult);
        assertEquals(registrationResult, "Re-entered password does not match!");
        UserAccount userAccount1 = userAccountManager.login(existingUserName, testPassword);
        assertNull(userAccount1);
        UserAccount userAccount2 = userAccountManager.login(existingUserName, testPassword + "123");
        assertNull(userAccount2);
    }
    public void testRegistrationWithInvalidPassword() {
        String registrationResult = userAccountManager.registerNewUser(
                testUserName,
                "invalid_password",
                "invalid_password",
                testFirstName,
                testLastName,
                testEmail,
                testPhone
        );
        System.out.println(registrationResult);
        assertTrue(registrationResult.equalsIgnoreCase("Invalid password.\n"));
        UserAccount userAccount = userAccountManager.login(testUserName, "invalid_password");
        assertNull(userAccount);
    }
    public void testRegistrationWithMultipleInvalidFields() {
        String registrationResult = userAccountManager.registerNewUser(
                "invalid_user",
                testPassword,
                testPassword,
                testFirstName,
                testLastName,
                testEmail,
                "234"
        );
        System.out.println(registrationResult);
        assertTrue(registrationResult.equalsIgnoreCase("Invalid user name.\nInvalid phone number.\n"));
        UserAccount userAccount = userAccountManager.login(testUserName, testPassword);
        assertNull(userAccount);
    }
    public void testRegistrationWithInvalidFirstName() {
        String registrationResult = userAccountManager.registerNewUser(
                testUserName,
                testPassword,
                testPassword,
                "12344",
                testLastName,
                testEmail,
                testPhone
        );
        System.out.println(registrationResult);
        assertTrue(registrationResult.equalsIgnoreCase("Invalid first name.\n"));
        UserAccount userAccount = userAccountManager.login(testUserName, testPassword);
        assertNull(userAccount);
    }

    public void testRegistrationWithInvalidLastName() {
        String registrationResult = userAccountManager.registerNewUser(
                testUserName,
                testPassword,
                testPassword,
                testFirstName,
                "Incorrect LastName",
                testEmail,
                testPhone
        );
        System.out.println(registrationResult);
        assertTrue(registrationResult.equalsIgnoreCase("Invalid last name.\n"));
        UserAccount userAccount = userAccountManager.login(testUserName, testPassword);
        assertNull(userAccount);
    }

    public void testRegistrationWithInvalidEmail() {
        String registrationResult = userAccountManager.registerNewUser(
                testUserName,
                testPassword,
                testPassword,
                testFirstName,
                testLastName,
                "Invalid@email@.com",
                testPhone
        );
        System.out.println(registrationResult);
        assertTrue(registrationResult.equalsIgnoreCase("Invalid email.\n"));
        UserAccount userAccount = userAccountManager.login(testUserName, testPassword);
        assertNull(userAccount);
    }

    public void testRegistrationWithInvalidPhoneNumber() {
        String registrationResult = userAccountManager.registerNewUser(
                testUserName,
                testPassword,
                testPassword,
                testFirstName,
                testLastName,
                testEmail,
                "234"
        );
        System.out.println(registrationResult);
        assertTrue(registrationResult.equalsIgnoreCase("Invalid phone number.\n"));
        UserAccount userAccount = userAccountManager.login(testUserName, testPassword);
        assertNull(userAccount);
    }
    public void testRegistrationWithAllInvalidFields() {
        String registrationResult = userAccountManager.registerNewUser(
                "invalid_user",
                "invalid_password",
                "invalid_password",
                "invalid_first_name",
                "invalid_last_name",
                "invalid_email@gmail@.com",
                "234"
        );
        System.out.println(registrationResult);
        assertTrue(
                registrationResult.equalsIgnoreCase(
                        "Invalid user name.\n" +
                                "Invalid password.\n" +
                                "Invalid first name.\n" +
                                "Invalid last name.\n" +
                                "Invalid email.\n" +
                                "Invalid phone number.\n")
        );
        UserAccount userAccount = userAccountManager.login(testUserName, testPassword);
        assertNull(userAccount);
    }



    

    
}
