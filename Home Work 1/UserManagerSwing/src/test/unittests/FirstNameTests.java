package test.unittests;

import junit.framework.TestCase;
import production.business.UserAccount;


public class FirstNameTests extends TestCase {

	public void testValidFirstName() {
		assertTrue(UserAccount.isLastNameValid("john")); 
	}
	public void testValidFirstNameWithLowercase() {
		assertTrue(UserAccount.isFirstNameValid("john"));
		assertTrue(UserAccount.isFirstNameValid("sam"));
	}

	public void testValidFirstNameWithUppercase() {
		assertTrue(UserAccount.isFirstNameValid("HARRY"));
		assertTrue(UserAccount.isFirstNameValid("JOHN"));
	}

	public void testValidFirstNameWithUpperAndLowercase() {
		assertTrue(UserAccount.isFirstNameValid("John"));
		assertTrue(UserAccount.isFirstNameValid("Harry"));
		assertTrue(UserAccount.isFirstNameValid("HarryPotter"));
	}

	public void testInValidFirstNameWithEmptyNameOrNull() {
		assertFalse(UserAccount.isFirstNameValid(""));
		assertFalse(UserAccount.isFirstNameValid(null));
	}

	public void testInValidFirstNameWithSpaces() {
		assertFalse(UserAccount.isFirstNameValid("John wayne"));
		assertFalse(UserAccount.isFirstNameValid("John	wayne"));
		assertFalse(UserAccount.isFirstNameValid("John\nwayne"));
	}

	public void testInValidFirstNameWithSpecialCharacters() {
		assertFalse(UserAccount.isFirstNameValid("John_wayne"));
		assertFalse(UserAccount.isFirstNameValid("Harry-Potter"));
		assertFalse(UserAccount.isFirstNameValid("HARRY@P"));
		assertFalse(UserAccount.isFirstNameValid("_HARRY"));
	}

	public void testInValidFirstNameWithNumbers() {
		assertFalse(UserAccount.isFirstNameValid("Harry89"));
		assertFalse(UserAccount.isFirstNameValid("89Harry"));
		assertFalse(UserAccount.isFirstNameValid("HARRY89Potter"));
	}

}
