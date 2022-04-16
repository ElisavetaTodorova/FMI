package model;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "user")
public class User {

	private String facultyNumber;
	private String firstName;
	private String lastName;
	private double score;
	private String userName;
	private String password;
	private UserType type;
	private boolean hasCourseSigned;
	
	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String facultyNumber, String firstName, String lastName, double score, String userName, String password, UserType type) {
		super();
		this.facultyNumber = facultyNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
		this.userName = userName;
		this.password = password;
		this.type = type;
	}
	
	public User(String facultyNumber, String firstName, String lastName, String userName, String password, UserType type) {
		super();
		this.facultyNumber = facultyNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.type = type;
	}
	

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getFacultyNumber() {
		return facultyNumber;
	}

	public void setFacultyNumber(String facultyNumber) {
		this.facultyNumber = facultyNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isHasCourseSigned() {
		return hasCourseSigned;
	}

	public void setHasCourseSigned(boolean hasCourseSigned) {
		this.hasCourseSigned = hasCourseSigned;
	}
	
	

}
