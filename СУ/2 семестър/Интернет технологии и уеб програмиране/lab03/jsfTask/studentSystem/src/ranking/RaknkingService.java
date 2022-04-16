package ranking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import courses.CourseService;
import dao.UserCourseService;
import dao.UserDao;

@ManagedBean(name="raknkingService")
@ApplicationScoped
public class RaknkingService {
	
	
	private List<StudentInfo> studentInfo;
	
	
	

	public RaknkingService() {
		this.studentInfo = build();
		
		
	}
	
	private List<StudentInfo> build() {
		List<StudentInfo> studentInfo = new ArrayList<>();
		
		
		Map<String, List<String>> results = UserCourseService.getUserCourseResults();
		
		Set<String> courseIds = results.keySet();
		
		for(String coursId: courseIds) {
			
			
			List<String> userIds = results.get(coursId);
			for(String uid: userIds) {
				StudentInfo info = new StudentInfo(CourseService.getCourseById(coursId), UserDao.getUserFacultyNumber(uid));
				studentInfo.add(info);
			}
			
		
		}
		
		
		
		return studentInfo;
	}

	public List<StudentInfo> getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(List<StudentInfo> studentInfo) {
		this.studentInfo = studentInfo;
	}
	
	
	
	

}
