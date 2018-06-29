package entity;

public class User {
	private String name;
	private String password;
	private String email;
	private int ishr;

	
	
	public User(String name, String password, String email, int ishr) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.ishr = ishr;
	}

	public int getIshr() {
		return ishr;
	}

	public void setIshr(int ishr) {
		this.ishr = ishr;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
