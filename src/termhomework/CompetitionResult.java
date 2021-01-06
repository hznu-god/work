package termhomework;
/**
 *
 * @author wily
 * @describe Record the results and ranking of each user
 * @version 2.0
 * 
 */
public class CompetitionResult implements Comparable<CompetitionResult>{
	/**
	 * The competition I participated in
	 */
	private Competition competition;
	
	/**
	 * Participating users
	 */
	private User user;
	
	/**
	 * The final score of the user
	 */
	private double score;
	
	/**
	 * The user's final competition ranking
	 */
	private int rank;
	
	public Competition getCompetition() {
		return competition;
	}
	
	public void setCompetition(Competition competition) {
		this.competition = competition;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public int compareTo(CompetitionResult o) {
		return (int) (o.getScore()-this.score);
	}

}
