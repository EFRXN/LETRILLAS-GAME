
public class User {
	String alias;
	int score;
	String time;
	String email;
	String password;
	//Constructor
	public User(String a, int s, String e) {
		alias = a;
		score = s;
		email = e;
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
	public void setEmail(String e) {
		email = e;
	}
	public void setPassword(String p) {
		password = p;
	}
	public void insertRegistroDB() {
		AccesoMongo.insertarUsuario("Usuarios", alias, email, password);
	}
	public void insertStatsDB() {
		AccesoMongo.insertarEstadisticas("Estadisticas", score, time, alias);
	}
}
