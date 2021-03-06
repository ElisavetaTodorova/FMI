package home;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

import com.login.ui.Util;

import dao.UserCourseDao;
import dao.UserDao;
import dao.UserNotFoundException;
import model.User;
import model.UserType;

@ManagedBean(name = "homeView")
public class HomeView {

	private User user;
	private boolean showCousesButton;
	private boolean showStatistincsButton;
	private boolean showRanking;

	@PostConstruct
	public void init() {
		HttpSession session = Util.getSession();
		if (session != null) {
			String userName = (String) session.getAttribute("username");
			try {
				user = UserDao.getUserByUserName(userName);
				showCousesButton = !UserCourseDao.hasSignedForCourses(user.getFacultyNumber()) && UserType.STUDENT.equals(user.getType());
				showStatistincsButton = UserType.TEACHER.equals(user.getType());
				
				for(User user: UserDao.getAllUsers()) {
					showRanking = true;
					if (!UserCourseDao.hasSignedForCourses(user.getFacultyNumber()) && UserType.STUDENT.equals(user.getType())) {
						showRanking = false;
					}
				}
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public String logout() {
		HttpSession session = Util.getSession();
		session.invalidate();
		return "login";
	}
	

	public boolean getShowCousesButton() {
		return showCousesButton;
	}

	public void setShowCousesButton(boolean showCousesButton) {
		this.showCousesButton = showCousesButton;
	}

	public boolean isShowStatistincsButton() {
		return showStatistincsButton;
	}

	public void setShowStatistincsButton(boolean showStatistincsButton) {
		this.showStatistincsButton = showStatistincsButton;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isShowRanking() {
		return showRanking;
	}

	public void setShowRanking(boolean showRanking) {
		this.showRanking = showRanking;
	}
	
	
	

}
