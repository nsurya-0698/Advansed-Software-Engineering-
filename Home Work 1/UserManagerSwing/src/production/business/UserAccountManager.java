package production.business;
import java.util.ArrayList;

public class UserAccountManager {
	
	public static final String NOINPUTERROR ="";
	
    private ArrayList<UserAccount> userAccounts;
    
    public UserAccountManager() {
        userAccounts = new ArrayList<UserAccount>();
    }
    
    // return an empty string if user registration is successful (all inputs are valid)
    // otherwise an error message.
    public String registerNewUser(String userName, String password, String reenteredPassword, 
    		String firstName, String lastName, String email, String phone){
    		String inputCheckResult = UserAccount.checkInputError(userName, password, firstName, lastName, email, phone);
    		
    		if (!inputCheckResult.equals(""))
    			return inputCheckResult;
    		if 	(doesUserNameExist(userName))
    			return "User name is not available!";
    		if (!password.equals(reenteredPassword)) {
    			return "Re-entered password does not match!";
    		}
    		UserAccount newAccount = new UserAccount();
    		setAccountProfile(newAccount, userName, password, firstName, lastName, email, phone);
    		userAccounts.add(newAccount);
    	    return NOINPUTERROR;
    }

    private void setAccountProfile(UserAccount userAccount, String userName, String password, String firstName, String lastName, String email, String phone){
		userAccount.setUserName(userName);
		userAccount.setPassword(password);
		userAccount.setFirstName(firstName);
		userAccount.setLastName(lastName);
		userAccount.setEmail(email);
		userAccount.setPhoneNumber(phone);
    }
    
    // return the user account if the given userName and password are correct
    // otherwise null
    public UserAccount login(String userName, String password) {
    		for (UserAccount userAccount: userAccounts)
    			if(userAccount.isValidCredential(userName, password))    
    				return userAccount;   
    		return null;
    }
    
    public boolean doesUserNameExist(String userName){
    		for (UserAccount userAccount: userAccounts)
    			if(userAccount.matchUserName(userName))   
    				return true;   
    		return false;
    }
    
}
