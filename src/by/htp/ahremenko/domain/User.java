package by.htp.ahremenko.domain;

public class User {
	private String name;
	private String login;
	private String password;

	public User (String l, String n) {
		login = l;
		name = n;
	}

	public User (String l) {
		login = l;
		name = l;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
