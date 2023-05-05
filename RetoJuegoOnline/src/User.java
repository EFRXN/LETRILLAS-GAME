
public class User {
	String alias;
	int score;
	String time;
	
	//Constructor
	public User(String a, int s) {
		alias = a;
		score = s;
	}
	public User(String a) {
		alias = a;
	}
	public User() {
		
	}
	
	//Methods
	public void setAlias(String a) {
		alias = a;
	}
	
	public void setScore(int s) {
		score = s;
	}
	public void setTime(String t) {
		time = t;
	}
}
