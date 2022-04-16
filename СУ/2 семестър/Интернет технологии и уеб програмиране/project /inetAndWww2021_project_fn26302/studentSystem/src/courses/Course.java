package courses;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="course")
public class Course {
	
	private String id;
	private String name;
	private String teacher;
	private int credits;
	
	
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String id, String name, String teacher, int credits) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.credits = credits;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Course clone() {
		return new Course(this.id, this.name, this.teacher, this.credits);
	}
	
	
	

}
