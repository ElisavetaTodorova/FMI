package courses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ReorderEvent;

import com.login.ui.Util;

import dao.UserCourseDao;
import dao.UserDao;
import dao.UserNotFoundException;

@ManagedBean(name = "dtCoursesViewView")
@RequestScoped
public class CoursesView implements Serializable {


	private static List<Course> courses;

	
	private static CourseService service = new CourseService();

	
	static {
		courses = service.getClonedCourses();
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void onRowReorder(ReorderEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Row Moved",
				"From: " + event.getFromIndex() + ", To:" + event.getToIndex());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onColReorder() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Columns reordered", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public String save() {
		List<String> courseIds = new ArrayList<>();
		this.getCourses().forEach(c -> courseIds.add(c.getId()));
		String userName = Util.getUserName();
		try {
			String facultyNumber = UserDao.getUserByUserName(userName).getFacultyNumber();
			UserCourseDao.addCourses(facultyNumber, courseIds);
			courses = service.getClonedCourses();
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}
}
