package test.acceptancetests;

import junit.framework.TestCase;
import production.business.UserAccount;
import production.business.UserAccountManager;


public class LoginTests extends TestCase{
	
    assertTrue(userAccount.getLastName().equalsIgnoreCase(validLastName));
    assertTrue(userAccount.getPhoneNumber().equalsIgnoreCase(validPhone)private UserAccountManager userAccountManager;

private final String validUserName = "admin";
private final String validPassword = "@Test1";
private final String validFirstName = "Scrum";
private final String validLastName = "Master";
private final String validEmail = "admin@umkc.edu";
private final String validPhone = "9132835734";

protected void setUp() throws Exception {
    super.setUp();
    userAccountManager = new UserAccountManager();
    userAccountManager.registerNewUser(
            validUserName,
            validPassword,
            validPassword,
            validFirstName,
            validLastName,
            validEmail,
            validPhone);
}


public void testValidUserLogin() {
    UserAccount userAccount = userAccountManager.login(validUserName, validPassword);
    assertNotNull(userAccount);
    assertTrue(userAccount.getEmail().equalsIgnoreCase(validEmail));
    assertTrue(userAccount.getFirstName().equalsIgnoreCase(validFirstName));
    assertTrue(userAccount.getLastName().equalsIgnoreCase(validLastName));
    assertTrue(userAccount.getPhoneNumber().equalsIgnoreCase(validPhone));
}

public void testValidUserLoginWithCaseInsensitiveUsername() {
    UserAccount userAccount = userAccountManager.login("Admin", validPassword);
    assertNotNull(userAccount);
    assertTrue(userAccount.getEmail().equalsIgnoreCase(validEmail));
    assertTrue(userAccount.getFirstName().equalsIgnoreCase(validFirstName));
);
}

public void testInvalidUserLoginWithNonExistingUsername() {
    UserAccount userAccount = userAccountManager.login("UserDoesNotExist", validPassword);
    assertNull(userAccount);
}

public void testInvalidUserLoginWithIncorrectPassword() {
    UserAccount userAccount = userAccountManager.login(validUserName, "@Test123");
    assertNull(userAccount);
}

}
