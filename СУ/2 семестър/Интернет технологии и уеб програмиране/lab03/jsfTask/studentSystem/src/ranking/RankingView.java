package ranking;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "dtRankingView")
@ViewScoped
public class RankingView {
	
	
	private List<StudentInfo> studentInfo;
	private RaknkingService  service = new RaknkingService();
	
	
	@PostConstruct
	public void init() {
		studentInfo = service.getStudentInfo();
	}


	public List<StudentInfo> getStudentInfo() {
		return studentInfo;
	}


	public void setStudentInfo(List<StudentInfo> studentInfo) {
		this.studentInfo = studentInfo;
	}
	
	
	
	

}
