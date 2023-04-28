
public class User {
	String alias;
	int score;
	long time;
	
	//Constructor
	public User(String a, int s) {
		alias = a;
		score = s;
	}
	public User(String a) {
		alias = a;
	}
	
	//Methods
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	public void setTime(long t) {
		this.time = time;
	}
}
