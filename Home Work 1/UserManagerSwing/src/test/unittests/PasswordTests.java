package test.unittests;

import junit.framework.TestCase;
import production.business.UserAccount;


public class PasswordTests extends TestCase {

	public void testValidPassword() {
		assertTrue(UserAccount.isPasswordValid("@White0House")); //Valid 	
	}
	public void testInvalidPasswordWithLessCharacters() {
		assertFalse(UserAccount.isPasswordValid("@da1t")); //invalid password should be >= 6
	}
	
	public void testInvalidPasswordWithNoUppercaseCharacters() {
		assertFalse(UserAccount.isPasswordValid("@surya0teja")); // Invalid need atlease one uppercase character 
	}

	public void testInvalidPasswordWithNoNumbers() {
		assertFalse(UserAccount.isPasswordValid("@SuryaTeja")); // Invalid need atleast one lowercase letter
	}

	public void testInvalidPasswordWithSpaces() {
		assertFalse(UserAccount.isPasswordValid("@Surya3 \nteja")); // Invalid spaces are not allowed 
	}

	public void testInvalidPasswordWithUnsupportedSpecialCharacters() {
		assertFalse(UserAccount.isPasswordValid("@S2uryaTeja*")); // Invalid Only few special characters are allowed
	}

	public void testInvalidPasswordWithEmptyPasswordOrNull() {
		assertFalse(UserAccount.isPasswordValid("")); // Invalid should meet the criterian 
		assertFalse(UserAccount.isPasswordValid(null)); // Invalid should meet the criterian 
	}
	public void testInvalidPasswordWithNoSpecialCharacters() {
		assertFalse(UserAccount.isPasswordValid("Surya77Teja")); // Invalid Should consistes atleast one special Character
	}
	public void testInvalidPasswordWithNoLowercaseCharacters() {
		assertFalse(UserAccount.isPasswordValid("SURYATEJA@")); // Should consistes of atleast one lowercase letter
	}






}
