package termhomework;
/**
 * 
 * @author wily
 * @describe Record relevant data of users, such as account number and password
 * @version 2.0
 * 
 */
public class User {
	/**
	 * User's account number
	 */
	private String userAccountNumber;
	
	/**
	 * User's password
	 */
	private String userPassword;
	
	/**
	 * Whether the user exists, whether it exists is true, and whether it does not exist is false
	 */
	private boolean existent=true;
	
	public String getUserAccountNumber() {
		return userAccountNumber;
	}
	
	public void setUserAccountNumber(String userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public boolean isExistent() {
		return existent;
	}
	
	public void setAvalible(boolean existent) {
		this.existent = existent;
	}
	
}
