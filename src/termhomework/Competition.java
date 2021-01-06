package termhomework;
import java.util.*;
/**
 * 
 * @author wily
 * @describe Record the relevant data of the competition, such as the name, content and number of participants 
 * @version 3.0
 *
 */
public class Competition {
	/**
	 *  Name of competition
	 */
	private String competitionName=null;
	
    /**
     * Number of participants
     */
	private Integer number=0;
   
	/**
	 * Competition content
	 */
	private String competitionContent=null;
    
	/**
	 * The state of the game, the start of the game is true, not start is false
	 */
	private Boolean state=null;
	
	/**
	 * Information of participants
	 */
	private List<User> usersList=new ArrayList<User>();
	
	public Competition() {}
	
	public Competition(String name, String content) {
		this.competitionName = name;
		this.competitionContent = content;
	}
	
	public String getCompetitionName() {
		return competitionName;
	}
	
	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getCompetitionContent() {
		return competitionContent;
	}
	
	public void setCompetitionContent(String competitionContent) {
		this.competitionContent = competitionContent;
	}

	public Boolean getState() {
		return state;
	}
	
	public void setState(Boolean state) {
		this.state = state;
	}
	
	public List<User> getUsersList() {
		return usersList;
	}
	
	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

}

