package termhomework;
import java.util.*;
/**
 * 
 * @author wily
 * @describe The main program of the system realizes a series of operations of the system
 * @version 4.0
 *  
 */
public class MainProgram {
	public static final String ONE=new String("1");
	public static final String TWO=new String("2");
	public static final String THREE=new String("3");
	public static final String FOUR=new String("4");
	public static final String FIVE=new String("5");
	public static final String SIX=new String("6");

	
    /**
     * @describe user related data
     */
	public static List<User> userList=new ArrayList<User>();
	
	
	/**
	 * @describe administrators related data
	 */
	public static List<User>administratorsList=new ArrayList<User>();
	
	
	/**
	 * @describe Competition related data
	 */
	public static List<Competition>competitionList=new ArrayList<Competition>();
	
	
	/**
	 * @describe Notice announcement related
	 */
	public static List<Notice> noticeList=new ArrayList<Notice>();
	
	
	/**
	 * @describe Data related to competition results
	 */
	public static List<CompetitionResult>competitionResultList=new ArrayList<CompetitionResult>();
	
	
	/**
	 * @describe User exits system
	 */
	public static void exitSystem() {
		System.out.println("------------System exited successfully!------------");
		System.exit(0);
	}
	
	
	/**
	 * @describe User returns to home page
	 */
	public static void returnHome() {
		main(null);
	}
	
	
	/**
	 * @describe User login
	 */
	public static void userLogin() {
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter the account number:");
		String username=input.nextLine();
		System.out.println("Please enter the password:");
		String password=input.nextLine();
		boolean success=false;
		boolean prohibit=false;
		for(User user:userList) {
			if(user.getUserAccountNumber().equals(username)){
				if(user.getUserPassword().equals(password)) {
					if(user.isExistent()==true) {
						success=true;
					}
					else {
						prohibit=true;
						System.out.println("The account has been disabled, please contact the administrator!");
					}
					break;
				}
			}
		}
		if(success) {
			System.out.println("Login successful!" + " Welcome to " +username);
			userHome(username);
		}
		else {
			if(!prohibit) {
				System.out.println("Account not registered or wrong password, login failed!");
			}
			System.out.println("Please select the following functions:");
			System.out.println("Login again: 1");
			System.out.println("Back to home: 2");
			System.out.println("Exit system: 3");
			while(true) {
				String choice=input.nextLine();
				if(ONE.equals(choice)) {
					userLogin();
					break;
				}
				else if(TWO.equals(choice)) {
					returnHome();
					break;
				}
				else if(THREE.equals(choice)) {
					exitSystem();
					break;
				}
				else {
		        	System.out.println("Please input the instruction correctly!");
		        	continue;
		        }
			}
		}
	}
	
	
	/**
	 * @describe Administrator login
	 */
	
	public static void administratorsLogin() {
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter the account number:");
		String username=input.nextLine();
		System.out.println("Please enter the password:");
		String password=input.nextLine();
		boolean success=false;
		for(User user:administratorsList) {
			if(user.getUserAccountNumber().equals(username)){
				if(user.getUserPassword().equals(password)) {
					success=true;
					break;
				}
			}
		}
		if(success) {
			System.out.println("Login successful!" + " Welcome to " + username);
			administratorsHome();
		}
		else {
			System.out.println("Account or password error");
			System.out.println("Please select the following functions:");
			System.out.println("Login again: 1");
			System.out.println("Back to home: 2");
			System.out.println("Exit system: 3");
			while(true) {
				String choice=input.nextLine();;
				if(ONE.equals(choice)) {
					administratorsLogin();
					break;
				}
				else if(TWO.equals(choice)) {
					returnHome();
					break;
				}
				else if(THREE.equals(choice)) {
					exitSystem();
					break;
				}
				else {
		        	System.out.println("Please input the instruction correctly!");
		        	continue;
		        }
			}
		}
	}
	
	
	/**
	 * @describe User registration
	 */
	public static void register() {
		Scanner input=new Scanner(System.in); 
		String password = null;
		String username = null;
		System.out.println("------register------");
		while(true) {
			boolean isRegister=true;
			System.out.println("Please enter the account number:");
			username=input.nextLine();

			for(User user:userList) {
				if(user.getUserAccountNumber().equals(username)) {
					isRegister=false;
					System.out.println("The account already exists, please re-enter!");
					System.out.println("Please select:");
					System.out.println("Re register: 1");
					System.out.println("Back to home: 2");
					System.out.println("Exit system: 3");
					while(true) {
						String choice=input.nextLine();;
						if(ONE.equals(choice)) {
							break;
						}
						else if(TWO.equals(choice)) {
							returnHome();
							break;
						}
						else if(THREE.equals(choice)){
							exitSystem();
							break;
						}
						else {
				        	System.out.println("Please input the instruction correctly!");
				        	continue;
				        }
					}
					break;
				}
			}
			if(isRegister){
				System.out.println("Please enter the password:");
			    password=input.nextLine();
				break;
			}
		}

		User user=new User();
		user.setUserAccountNumber(username);
		user.setUserPassword(password);
		userList.add(user);
		System.out.println("Registration successful!");
		System.out.println("Please select:");
		System.out.println("Login system: 1");
		System.out.println("Back to home: 2");
		System.out.println("Exit system: 3");
		while(true) {
			String choice=input.nextLine();;
			if(ONE.equals(choice)) {
				userLogin();
				break;
			}
			else if(TWO.equals(choice)) {
				returnHome();
				break;
			}
			else if(THREE.equals(choice)){
				exitSystem();
				break;
			}
			else {
	        	System.out.println("Please input the instruction correctly!");
	        	continue;
	        }
		}
	}
	
	
	/**
	 * @describe User home page
	 * @param username 
	 * 		           Login user name
	 */
	private static void userHome(String username) {
		
		System.out.println("Dear users, welcome back!");
		System.out.println("Please select the following functions:");
		System.out.println("--------------------------");
		System.out.println("Competition Registration: 1");
		System.out.println("View competition notice: 2");
		System.out.println("Competition results inquiry: 3");
		System.out.println("Back to home: 4");
		System.out.println("Exit system: 5");
		Scanner input=new Scanner(System.in);
		while(true) {
			String choice=input.nextLine();;
			if(ONE.equals(choice)) {
				competitionRegister(username);
				break;
			}
			else if(TWO.equals(choice)) {
				competitionNotice(username);
				break;
			}
			else if(THREE.equals(choice)) {
				competitionResultsInquiry(username);
				break;
			}
			else if(FOUR.equals(choice)) {
				returnHome();
				break;
			}
			else if(FIVE.equals(choice)) {
				exitSystem();
				break;
			}
			else {
	        	System.out.println("Please input the instruction correctly!");
	        	continue;
	        }
		}
	}

	
	/**
	 * @describe Administrator home page
	 */
	private static void administratorsHome() {
		Scanner input=new Scanner(System.in);
		System.out.println("Dear administrator, welcome back!");
		System.out.println("Please select the following functions to operate:");
		System.out.println("--------------------------");
		System.out.println("Account management: 1");
		System.out.println("Competition management: 2");
		System.out.println("Score management: 3");
		System.out.println("Notification management: 4");
		System.out.println("Back to home: 5");
		System.out.println("Exit system: 6");
		while(true) {
			String choice=input.nextLine();;
			if(ONE.equals(choice)) {
				accountManage();
				break;
			}
			else if(TWO.equals(choice)) {
				competitionManage();
				break;
			}
			else if(THREE.equals(choice)) {
				scoreManage();
				break;
			}
	        else if(FOUR.equals(choice)) {
	        	noticeManage();
	        	break;
			}
	        else if(FIVE.equals(choice)) {
	        	returnHome();
	        	break;
	        }
	        else if(SIX.equals(choice)) {
	        	exitSystem();
	        	break;
	        }
	        else {
	        	System.out.println("Please input the instruction correctly!");
	        	continue;
	        }
		}
	}
	
	
	/**
	 * @describe User Competition Registration
	 * @param name
	 * 			   Login user name
	 */
	private static void competitionRegister(String name) {
		Scanner input=new Scanner(System.in);
		System.out.println("Please select the name of the competition you want to sign up for:");
		String competitionName=input.nextLine();
		boolean competitionexistence=false;
		Competition competition = null;
		for(Competition temp:competitionList) {
			if(temp.getCompetitionName().equals(competitionName)) {
				competitionexistence=true;
				competition=temp;
				break;
			}
		}
		if(competitionexistence) {
			String username=name;
			for(User user:userList) {
				if(user.getUserAccountNumber().equals(username)) {
					System.out.println("To confirm whether to register for the competition, press 1 for confirmation and 2 for cancellation");
					while(true) {
						String choice=input.nextLine();;
						if(ONE.equals(choice)) {
							competition.getUsersList().add(user);
							competition.setNumber(competition.getNumber()+1);
							System.out.println("Congratulations on your successful registration!");
							break;
						}
						else if(TWO.equals(choice)){
							System.out.println("Registration failed!");
							break;
						}
						else {
				        	System.out.println("Please input the instruction correctly!");
				        	continue;
				        }
					}
				}
			}
			System.out.println("Will automatically jump to the user's home page，，，，");
			userHome(name);
		}
		else {
			System.out.println("Competition does not exist, will return to the user's home page");
			userHome(name);
		}
	}

	
	/**
	 * @describe Users view competition announcements
	 * @param name
	 *            Login user name 
	 */
	private static void competitionNotice(String name) {
		System.out.println("Next, I'll show you the latest competition notice");
		int index=1;
		for(Notice notice:noticeList) {
			System.out.println("notice"+index+":");
			System.out.println("Notice name:"+notice.getName());
			System.out.println("Notice content:"+notice.getContent());
			System.out.println("------------------------------");
			index++;
		}
		System.out.println("Will automatically jump to the user's home page，，，，");
		userHome(name);
	}
	
	
	/**
	 * @describe User competition result query
	 * @param name 
	 *            Login user name
	 */
	private static void competitionResultsInquiry(String name) {
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter the name of the competition you want to query:");
		List <CompetitionResult> competitionDatas = new ArrayList<CompetitionResult>() ;
		boolean competitionexistence=false;
		String competitionName=input.nextLine();
		for(CompetitionResult result:competitionResultList) {
			if(result.getCompetition().getCompetitionName().equals(competitionName)) {
				competitionexistence=true;
				competitionDatas.add(result);
			}
		}
		Collections.sort(competitionDatas);
		
		if(!competitionexistence) {
			System.out.println("The competition does not exist or no ONE has signed up for it");
		}
		else {
			System.out.println(competitionName+" the top 10 are as follows:");
			int index=1;
			for(CompetitionResult value:competitionDatas) {
				if(index>10) {
					break;
				}
				System.out.println("The "+index+" place:"+value.getUser().getUserAccountNumber());
				index++;
			}
		}
		String username=name;
		int index=1;
		System.out.println(competitionName);
		for(CompetitionResult data:competitionDatas) {
			if(data.getUser().getUserAccountNumber().equals(username)) {
				System.out.println("Your score: "+data.getScore()+" Your ranking:"+index);
				index++;
				break;
			}
		}
		System.out.println("Will automatically jump to the user's home page，，，，");
		userHome(name);
	}
	
	
	/**
	 * @describe The administrator manages the account
	 */
	private static void accountManage() {
		System.out.println("Please select the following operation to manage the user account:");
		System.out.println("--------------------------");
		System.out.println("Account query: 1");
		System.out.println("Account disabled: 2");
		System.out.println("Reset password: 3");
		System.out.println("Back to administrator home page: 4");
		System.out.println("Back to home: 5");
		Scanner input=new Scanner(System.in);
		while(true) {
			String choice=input.nextLine();;
			if(ONE.equals(choice)) {
				accountInquiry();
				break;
			}
			else if(TWO.equals(choice)) {
				accountDisabled();
				break;
			}
			else if(THREE.equals(choice)) {
				resetPassword();
				break;
			}
	        else if(FOUR.equals(choice)) {
	        	administratorsHome();
	        	break;
			}
	        else if(FIVE.equals(choice)) {
	        	returnHome();
	        	break;
	        }
	        else {
	        	System.out.println("Please input the instruction correctly!");
	        	continue;
	        }
		}
	}

	
	/**
	 * @describe The administrator queries the account number
	 */
	private static void accountInquiry() {
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter the account number to be queried:");
		String username=input.nextLine();
		boolean success=false;
		for(User user:userList) {
			if(user.getUserAccountNumber().equals(username)) {
				success=true;
				System.out.println("query was successful");
				System.out.println(user);
				break;
			}
		}
		if(!success) {
			System.out.println("No such account information, query failed");
			System.out.println("Do you want to continue the query operation");
			System.out.println("To continue the query, press 1. To return to the account management interface, press 2");
			while(true) {
				String choice=input.nextLine();;
				if(ONE.equals(choice)) {
					accountInquiry();
					break;
				}
				else if(TWO.equals(choice)) {
					accountManage();
					break;
				}
				else {
		        	System.out.println("Please input the instruction correctly!");
		        	continue;
		        }
			}
		}
	}

	
	/**
	 * @describe The administrator can disable the account
	 */
	private static void accountDisabled() {
		System.out.println("Please enter the account to be disabled:");
		Scanner input=new Scanner(System.in);
		String username=input.nextLine();
		for(User user:userList) {
			if(user.getUserAccountNumber().equals(username)) {
				System.out.println("To confirm whether to disable the user, enter 1 to confirm, or press 2 to cancel");
				while(true) {
					String choice=input.nextLine();;
					if(ONE.equals(choice)) {
						user.setAvalible(false);
						System.out.println("Disable successfully!");
						break;
					}
					else if(TWO.equals(choice)){
						System.out.println("Disable failed!");	
						break;
					}
					else {
			        	System.out.println("Please input the instruction correctly!");
			        	continue;
			        }
				}
				
				break;
			}
		}
		System.out.println("Automatically jump to the account management interface，，，，");
		accountManage();		
	}

	
	/**
	 * @describe The administrator reset the password
	 */
	private static void resetPassword() {
		System.out.println("Please enter the account number to reset the password:");
		Scanner input=new Scanner(System.in);
		String username=input.nextLine();
		boolean success=false;
		for(User user:userList) {
			if(user.getUserAccountNumber().equals(username)) {
				success=true;
				System.out.println("To confirm whether to reset the password, press 1 to confirm or 2 to cancel");
				while(true) {
					String choice=input.nextLine();;
					if(ONE.equals(choice)) {
						System.out.println("Please enter the password to reset:");
						String password=input.next();
						user.setUserPassword(password);
						System.out.println("Reset successfully");
						break;
					}
					else if(TWO.equals(choice)) {
						System.out.println("Reset failed");
						break;
					}
					else {
			        	System.out.println("Please input the instruction correctly!");
			        	continue;
			        }
				}
				
			}
		}
		//No account information query failed
		if(!success) {
			System.out.println("Query failed, no account information, please check!");
		}
		System.out.println("Do you want to continue with the reset operation");
		System.out.println("To continue to reset the password, press 1. To return to the account management interface, press 2:");
		while(true) {
			String choice=input.nextLine();;
			if(ONE.equals(choice)) {
				resetPassword();
				break;
			}
			else if(TWO.equals(choice)) {
				accountManage();
				break;
			}
			else {
	        	System.out.println("Please input the instruction correctly!");
	        	continue;
	        }
		}
	}

	
	/**
	 * @describe The administrator manages the competition
	 */
	private static void competitionManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("Please select the following operation to manage the user account:");
		System.out.println("--------------------------");
		System.out.println("New competitions: 1");
		System.out.println("Handle competition: 2");
		System.out.println("Count registration information: 3");
		System.out.println("Back to administrator home page: 4");
		while(true) {
			int index=input.nextInt();
			if(index==1) {
				newCompetition();
				break;
			}
			else if(index==2) {
				handleCompetition();
				break;
			}
			else if(index==3) {
				checkRegister();
				break;
			}
			else if(index==4) {
				administratorsHome();
				break;
			}
			else {
	        	System.out.println("Please input the instruction correctly!");
	        	continue;
	        }
		}
	}
	

	/**
	 * @describe The administrator to add competition operation
	 */
	private static void newCompetition() {
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter the name of the competition:");
		String name=input.nextLine();
		System.out.println("Please input the competition content:");
		String content=input.nextLine();
		System.out.println("To confirm whether to add, press 1 to confirm and 2 to cancel");
		while(true) {
			String choice=input.nextLine();
			if(ONE.equals(choice)) {
				Competition competition=new Competition(name,content);
				competitionList.add(competition);
				System.out.println("New competition succeeded!");
				break;
			}
			else if(TWO.equals(choice)){
				System.out.println("New competition failed!");
				break;
			}
			else {
	        	System.out.println("Please input the instruction correctly!");
	        	continue;
	        }
		}
		System.out.println("Automatically jump to the account management interface，，，，");
		administratorsHome();
	}

	
	/**
	 * @describe The administrator starts and stops the competition
	 */
	private static void handleCompetition() {
		Scanner input=new Scanner(System.in);
		System.out.println("Please select the name of the competition you want to start or stop:");
		String name=input.nextLine();
		boolean existence=false;
		for(Competition competition:competitionList) {
			if(competition.getCompetitionName().equals(name)) {
				existence=true;
				System.out.println("Please choose to start or stop the competition, 1 is to start, 2 is to stop:");
				while(true) {
					String choice=input.nextLine();;
					if(ONE.equals(choice)) {
						competition.setState(true);
						System.out.println("Open successfully");
						break;
					}
					else if(TWO.equals(choice)) {
						competition.setState(false);
						System.out.println("Stop success");
						break;
					}
					else {
			        	System.out.println("Please input the instruction correctly!");
			        	continue;
			        }
				}
			}
			
		}
		if(!existence) {
			System.out.println("The competition does not exist");
		}
		System.out.println("Automatically jump to the account management interface，，，，");
		administratorsHome();
	}

	
	/**
	 * @describe The administrator to query the registration operation
	 */
	private static void checkRegister() {
		System.out.println("Please enter the name of the competition you want to query");
		Scanner input=new Scanner(System.in);
		String name=input.nextLine();
		boolean existence=false;
		for(Competition competition:competitionList) {
			if(competition.getCompetitionName().equals(name)) {
				existence=true;
				System.out.println("The " + competition.getCompetitionName() +" registration of the above personnel is as follows:");
				System.out.println("A total of "+competition.getNumber()+"users signed up");
				for(User user:competition.getUsersList()) {
					System.out.println(user);
				}
			}
			
		}
		if(!existence) {
			System.out.println("The competition does not exist");
		}
		System.out.println("Automatically jump to the account management interface，，，，");
		administratorsHome();	
	}

	
	/**
	 * @describe The administrator manages the competition results
	 */
	private static void scoreManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("Please select the following operation to manage the competition results:");
		System.out.println("--------------------------");
		System.out.println("Entry result: 1");
		System.out.println("Query the results and ranking of users: 2");
		System.out.println("Query competition ranking: 3");
		System.out.println("Back to administrator home page: 4");
		while(true) {
			String choice=input.nextLine();
			if(ONE.equals(choice)) {
				insertScore();	
				break;
			}
			else if(TWO.equals(choice)) {
				queryUserResult();
				break;
			}
			else if(THREE.equals(choice)) {
				queryRank();
				break;
			}
			else if(FOUR.equals(choice)) {
				administratorsHome();
				break;
			}
			else {
	        	System.out.println("Please input the instruction correctly!");
	        	continue;
	        }
		}
	}
	

	/**
	 * @describe The administrator to enter the results of the competition operation
	 */
	private static void insertScore() {
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter the name of the competition");
		String name=input.nextLine();
		boolean competitionexistence=false;
		for(Competition competition:competitionList) {
			if(competition.getCompetitionName().equals(name)) {
				competitionexistence=true;
				boolean userExistence=false;
				System.out.println("Please enter the account number:");
				String username=input.nextLine();
				for(User user:userList) {
					if(user.getUserAccountNumber().equals(username)) {
						userExistence=true;
						System.out.println("Please enter the score of the user:");
						double score=input.nextDouble();
						CompetitionResult competitionresult=new CompetitionResult();
						competitionresult.setCompetition(competition);
						competitionresult.setUser(user);
						competitionresult.setScore(score);
						competitionResultList.add(competitionresult);
						System.out.println("Score entered successfully");
						break;
					}	
				}
				if(!userExistence) {
					System.out.println("The user does not exist");					
				}
				break;
			}
		}
		if(!competitionexistence) {
			System.out.println("The competition doesn't exist!");
		}
		System.out.println("Automatically jump to the account management interface，，，，");
		administratorsHome();
	}

	
	/**
	 * @describe The administrator to query user performance and ranking operation performance operation
	 */
	private static void queryUserResult() {
		List <CompetitionResult> competitionresult = new ArrayList<CompetitionResult>() ;
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter the name of the competition");
		String name=input.nextLine();
		boolean competitionexistence=false;
		int z=0;
		for(CompetitionResult value:competitionResultList) {
			if(value.getCompetition().getCompetitionName().equals(name)) {
				competitionexistence=true;
			 competitionresult.add(value);
			}
		}
		Collections.sort(competitionresult);
		if(!competitionexistence) {
			System.out.println("The competition does not exist or there is no user registration");
		}
		else {
			boolean userExistence=false;
			System.out.println("Please enter the account number you want to query");
			String username=input.nextLine();
			int index=1;
			for(CompetitionResult value:competitionresult) {
				if(value.getUser().getUserAccountNumber().equals(username)) {
					userExistence=true;
					System.out.println("query was successful");
					System.out.println("The results of the user are as follows: "+value.getScore());
					System.out.println("The ranking is "+ index);
				}
				index++;
			}
			if(!userExistence) {
				System.out.println("The user does not exist!");
			}
			System.out.println("Automatically jump to the account management interface，，，，");
			administratorsHome();
		}
	}

	
	/**
	 * @describe The administrator to query the ranking list operation results operation
	 */
	private static void queryRank() {
		List <CompetitionResult> competitionresult = new ArrayList<CompetitionResult>() ;
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter the competition you want to query:");
		String name=input.nextLine();
		boolean competitionexistence=false;
		for(CompetitionResult value:competitionResultList) {
			if(value.getCompetition().getCompetitionName().equals(name)) {
				competitionexistence=true;
			 competitionresult.add(value);
			}
		}
		Collections.sort(competitionresult);
		if(!competitionexistence) {
			System.out.println("The competition does not exist or there is no user registration");
		}
		else {
			System.out.println("The "+ name +" ranking is as follows:");
			int index=1;
		for(CompetitionResult value:competitionresult) {
			System.out.println("The "+index+" place is :"+value.getUser().getUserAccountNumber());
			index++;
		}
		}
		System.out.println("Automatically jump to the account management interface，，，，");
		administratorsHome();
	}

	
	/**
	 * @describe The administrator manages the competition notification
	 */
	private static void noticeManage() {
		Scanner input=new Scanner(System.in);
		System.out.println("Please perform the following operations to manage the competition notice:");
		System.out.println("--------------------------");
		System.out.println("Add notification: 1");
		System.out.println("Delete notification: 2");
		System.out.println("Update notification: 3");
		System.out.println("Query notification: 4");
		System.out.println("Back to administrator home page: 5");
		while(true) {
			String choice=input.nextLine();;
			if(ONE.equals(choice)) {
				insertNotice();
				break;
			}
			else if(TWO.equals(choice)) {
				deleteNotice();
				break;
			}
			else if(THREE.equals(choice)) {
				updateNotice();
				break;
			}
			else if(FOUR.equals(choice)) {
				queryNotice();
				break;
			}
			else if(FIVE.equals(choice)) {
				administratorsHome();
				break;
			}
			else {
	        	System.out.println("Please input the instruction correctly!");
	        	continue;
	        }
		}
	}


	/**
	 * @describe The administrator to add notification operation results operation
	 */
	private static void insertNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter the announcement Name:");
		String name=input.nextLine();
		boolean noticeExistence=false;
		for(Notice notice:noticeList) {
			if(notice.getName().equals(name)) {
				noticeExistence=true;
				break;
			}
		}
		if(noticeExistence) {
			System.out.println("The notification already exists!");
		}
		else {
			System.out.println("Please enter the notification content:");
			String content=input.nextLine();
		    Notice notice=new Notice();
		    notice.setName(name);
		    notice.setContent(content);
		    noticeList.add(notice);
		    System.out.println("Add notification successfully!");
		}
		System.out.println("Automatically jump to the account management interface，，，，");
		administratorsHome();
	}

	
	/**
	 * @describe The administrator to delete notification operation results operation
	 */
	private static void deleteNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter a name for the notification");
		String name=input.nextLine();
		boolean noticeExistence=false;
		for(Notice notice:noticeList) {
			if(notice.getName().equals(name)) {
				noticeExistence=true;
				System.out.println("To confirm whether to delete the notice, press 1 to confirm or 2 to cancel");
				while(true) {
					String choice=input.nextLine();;
					if(ONE.equals(choice)) {
						noticeList.remove(notice);
						System.out.println("Delete successfully!");
						break;
					}
					else if(TWO.equals(choice)) {
						System.out.println("Cancel deletion!");
						break;
					}
					else {
			        	System.out.println("Please input the instruction correctly!");
			        	continue;
			        }
				}
				break;
			}
		}
		if(!noticeExistence) {
			System.out.println("The notification does not exist!");
		}
		System.out.println("Automatically jump to the account management interface，，，，");
		administratorsHome();
	}

	
	/**
	 * @describe The administrator update notification operation results operation
	 */
	private static void updateNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter the name of the notification:");
		String name=input.nextLine();
		boolean noticeExistence=false;
		int index=0;
		for(Notice notice:noticeList) {
			if(notice.getName().equals(name)) {
				noticeExistence=true;
				System.out.println("Please enter the content to be updated:");
				String content=input.nextLine();
				noticeList.get(index).setContent(content);
				System.out.println("Notification updated!");
			}
			index++;
		}
		if(!noticeExistence) {
			System.out.println("The notification does not exist!");
		}
		System.out.println("Automatically jump to the account management interface，，，，");
		administratorsHome();
	}

	
	/**
	 * @describe The administrator query notification operation results operation
	 */
	private static void queryNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter a name for the notification");
		String name=input.nextLine();
		boolean noticeExistence=false;
		for(Notice notice:noticeList) {
			if(notice.getName().equals(name)) {
				noticeExistence=true;
				System.out.println("Notice Name:"+notice.getName());
				System.out.println("Notice content:"+notice.getContent());
				break;
			}
		}
		if(!noticeExistence) {
			System.out.println("The announcement does not exist!");
		}
		System.out.println("Automatically jump to the account management interface，，，，");
		administratorsHome();
	}
	
	
	/**
	 * @describe Initially create an administrator account and add it to the administrator list
	 */
	public static void init() {
		User administrators=new User();
		administrators.setUserAccountNumber("admin");
		administrators.setUserPassword("admin123");
		administratorsList.add(administrators);
		User user1=new User();
		User user2=new User();
		User user3=new User();
		User user4=new User();
		user1.setUserAccountNumber("Lily");
		user1.setUserPassword("123456");
		userList.add(user1);
		user2.setUserAccountNumber("Mark");
		user2.setUserPassword("456789");
		userList.add(user2);
		user3.setUserAccountNumber("Betty");
		user3.setUserPassword("147852369");
		userList.add(user3);
		user4.setUserAccountNumber("Tom");
		user4.setUserPassword("666666");
		userList.add(user4);
	}
	
	
	/**
	 * @describe Start the system and enter the main interface
	 * @param args
	 */
	public static void main(String[] args) {
			init();
			Scanner input=new Scanner(System.in); 
			System.out.println("------------Welcome to the marathon information management system!-----------");
			System.out.println("----------------------------------------------------");
			System.out.println("------------Registration: 1------------");
			System.out.println("------------User login: 2------------");
			System.out.println("------------Administrator login: 3------------");
			System.out.println("(administratorsAccount:admin----administratorsPassword:admin123)");
			while(true) {
				String choice=input.nextLine();;
				if(ONE.equals(choice)) {
					register();
					break;
				}
				else if(TWO.equals(choice)) {
					userLogin();
					break;
				}
				else if(THREE.equals(choice)){
					administratorsLogin();
					break;
				}
				else {
		        	System.out.println("Please input the instruction correctly!");
		        	continue;
		        }
			}
		}
}
