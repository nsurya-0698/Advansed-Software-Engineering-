package test.sampleAcceptanceTests;

import junit.framework.TestCase;
import production.business.UserAccount;
import production.business.UserAccountManager;

public class SampleTest extends TestCase {

	private UserAccountManager userAccountManager;

	protected void setUp() throws Exception {
		super.setUp();
		userAccountManager = new UserAccountManager();
		userAccountManager.registerNewUser("admin", "@umkcFH560B", "@umkcFH560B", "Scrum", "Master", "admin@umkc.edu",
				"9132835734");
	}

	public void testSuccessfulRegistration() {
		String registrationResult = userAccountManager.registerNewUser("jsmith", "@White0House", "@White0House", "John",
				"Smith", "john.smith@gmail.com", "7024265734");
		assertEquals(registrationResult, UserAccountManager.NOINPUTERROR);
		UserAccount userAccount = userAccountManager.login("jsmith", "@White0House");
		assertNotNull(userAccount);
		assertTrue(userAccount.getEmail().equalsIgnoreCase("john.smith@gmail.com"));
	}

	// this test may fail if the isUserNameValid method is not completed
	public void testRegistrationWithInvalidUserName() {
		String registrationResult = userAccountManager.registerNewUser("2020", "@White0House", "@White0House",
				"John", "Smith", "johnsmith@gmail.com", "7024265734");
		System.out.println(registrationResult);
		assertFalse(registrationResult.equalsIgnoreCase(UserAccountManager.NOINPUTERROR));
	}

}
