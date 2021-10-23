package test.unittests;

import junit.framework.TestCase;
import production.business.UserAccount;


public class PhoneNumberTests extends TestCase {

	public void testValidPhoneNumber() {
		assertTrue(UserAccount.isPhoneNumberValid("8162356218")); //Valid 
	}
	public void testInValidPhoneNumberWithLessDigitsOrNull() {
		assertFalse(UserAccount.isPhoneNumberValid("7730000")); //Invaild should consistes of more numbers 
		assertFalse(UserAccount.isPhoneNumberValid("")); // Invalid input
		assertFalse(UserAccount.isPhoneNumberValid(null)); // Invalid input
	}

	public void testInValidPhoneNumberWithMoreDigits() {
		assertFalse(UserAccount.isPhoneNumberValid("1988927807881378071")); // Invalid 
	}

	// US 3 digit area code and 7 digit phone number doesn't start with either 0 or 1
	public void testInValidPhoneNumberWithSpecialConditions() {
		assertFalse(UserAccount.isPhoneNumberValid("0162356218"));
		assertFalse(UserAccount.isPhoneNumberValid("1162356218"));
		assertFalse(UserAccount.isPhoneNumberValid("8160356218"));
		assertFalse(UserAccount.isPhoneNumberValid("8161356218"));
		assertFalse(UserAccount.isPhoneNumberValid("0160356218"));
		assertFalse(UserAccount.isPhoneNumberValid("0161356218"));
		assertFalse(UserAccount.isPhoneNumberValid("1160356218"));
		assertFalse(UserAccount.isPhoneNumberValid("1161356218"));
	}

	public void testInValidPhoneNumberWithAlphabets() {
		assertFalse(UserAccount.isPhoneNumberValid("81623562ab")); //Invalid Should not consistes of characters 
		assertFalse(UserAccount.isPhoneNumberValid("81623sb562")); //Invalid Should not consistes of characters 
		assertFalse(UserAccount.isPhoneNumberValid("8162356243ab")); //Invalid Should not consistes of characters 
		assertFalse(UserAccount.isPhoneNumberValid("ab8162356243")); //Invalid Should not consistes of characters 
		assertFalse(UserAccount.isPhoneNumberValid("816235ab6243"));//Invalid Should not consistes of characters 
	}

	public void testInValidPhoneNumberWithSpecialCharacters() {
		assertFalse(UserAccount.isPhoneNumberValid("7712223@#")); // No special characters 
		assertFalse(UserAccount.isPhoneNumberValid("917171#562"));  // No special characters 
		assertFalse(UserAccount.isPhoneNumberValid("7188181881@#"));// No special characters 
		assertFalse(UserAccount.isPhoneNumberValid("@#811133")); // No special characters 
		assertFalse(UserAccount.isPhoneNumberValid("12333@#6243")); // No special characters 
	}

	public void testInValidPhoneNumberWithSpaces() {
		assertFalse(UserAccount.isPhoneNumberValid("6777 511111")); // Invalid spaces are not allowed 
		assertFalse(UserAccount.isPhoneNumberValid("11118 546243")); // Invalid spaces are not allowed 
		assertFalse(UserAccount.isPhoneNumberValid("7730001998 ")); // Invalid spaces are not allowed 
	}



}
