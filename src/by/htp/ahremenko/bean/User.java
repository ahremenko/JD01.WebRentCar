package by.htp.ahremenko.bean;

public class User {
	private String name;
	private String login;
	private String password;
	private int isAdmin;
	private int id;

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

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int is_admin) {
		this.isAdmin = is_admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
