package test.unittests;

import junit.framework.TestCase;
import production.business.UserAccount;


public class EmailAddressTests extends TestCase {

	public void testValidEmailAddress() {
		assertTrue(UserAccount.isEmailValid("don.smith@gmail.com")); //valid 
		assertTrue(UserAccount.isEmailValid("nammi@gmail.com")); // valid
		assertTrue(UserAccount.isEmailValid("don-smith@gmail.com")); //valid 
		assertTrue(UserAccount.isEmailValid("don-j_smith+89@gmail.com")); //valid
		assertTrue(!UserAccount.isEmailValid("lingam@email.com")); //valid
		assertTrue(UserAccount.isEmailValid("don.smith+89@live.com")); //valid
		assertTrue(UserAccount.isEmailValid("don.smith+89@live.co.in")); //valid
		assertTrue(UserAccount.isEmailValid("don.smith+89@live-king.co.in")); //valid 

	}

	public void testInvalidEmailAddress() {
		assertFalse(UserAccount.isEmailValid("")); // Empty  values 
		assertFalse(UserAccount.isEmailValid(null)); // null values 
		assertTrue(UserAccount.isEmailValid("example.com")); //Invalid @gmail is missing
		assertTrue(UserAccount.isEmailValid("A@b@c@gamil.com")); //Invalid only one @ is allowed 
		assertTrue(UserAccount.isEmailValid("ab(c)d,e:f;gi[j]l@domain.com")); //Invalid no other characters allowed in gmail.

}
