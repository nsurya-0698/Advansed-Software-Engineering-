package test.unittests;

import junit.framework.TestCase;
import production.business.UserAccount;


public class UserNameTests extends TestCase {

	public void testValidUserName() {
		assertTrue(UserAccount.isUserNameValid("admin")); //valid 
	}
	public void testValidUserNameWithLetterAndDigits() {
		assertTrue(UserAccount.isUserNameValid("surya89")); 
		assertTrue(UserAccount.isUserNameValid("Surya89")); 
		assertTrue(UserAccount.isUserNameValid("Su89rya"));
	}

	public void testValidUserNameWithUpperCaseCharacters() {
		assertTrue(UserAccount.isUserNameValid("SURYA"));
		assertTrue(UserAccount.isUserNameValid("SU89RYA"));
	}

	public void testInvalidUserNameWithEmptyUsernameOrNull() {
		assertFalse(UserAccount.isUserNameValid(""));
		assertFalse(UserAccount.isUserNameValid(null));
	}

	public void testInvalidUserNameWithIncorrectStartingCharacter() {
		assertFalse(UserAccount.isUserNameValid("10SURYA"));
		assertFalse(UserAccount.isUserNameValid("_surya89"));
	}

	public void testInvalidUserNameWithSpecialCharacters() {
		assertFalse(UserAccount.isUserNameValid("Suryateja_"));
	}



}
