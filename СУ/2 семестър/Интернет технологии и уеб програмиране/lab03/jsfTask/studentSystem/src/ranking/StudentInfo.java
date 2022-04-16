package ranking;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import courses.Course;
import model.User;

@ManagedBean(name = "studentInfo")
@ViewScoped
public class StudentInfo {

	
	
	private Course course;
	private User student;
	public StudentInfo(Course course, User student) {
		super();
		this.course = course;
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	

	
	
	
}
