package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UserCourseService {

	public static Map<String, int[]> getData() {
		Map<String, int[]> result = new HashMap<String, int[]>();

		Map<String, String[]> userCourses = UserCourseDao.getUserCoursesMap();

		Collection<String[]> courseStats = userCourses.values();

		Iterator iterator = courseStats.iterator();

		while (iterator.hasNext()) {
			String[] coursesInfo = (String[]) iterator.next();

			for (int i = 0; i < coursesInfo.length; i++) {
				String courseName = coursesInfo[i];

				if (result.get(courseName) == null) {
					int[] initial = new int[4];
					result.put(courseName, initial);
				}

				int prevours = (result.get(courseName)[i] + 1);
				result.get(courseName)[i] = prevours;

			}
		}

		return result;
	}

	public static Map<String, List<String>> getUserCourseResults() {
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		Map<String, String[]> userCourses = UserCourseDao.getUserCoursesMap();


		Set<String> userIds = userCourses.keySet();
		int numberOfCourses = 4;
		Map<String, Integer> tempUiserIdCourseMap = new HashMap<>();
		for (int i = 0; i < numberOfCourses; i++) {

			Map<String, Map<String, Double>> temp = new HashMap<>();
			for (String id : userIds) {
				String courseId = userCourses.get(id)[i];

				Map<String, Double> userScoreMap = temp.get(courseId);
				if (userScoreMap == null) {
					temp.put(courseId, new HashMap<String, Double>());
				} 
				userScoreMap.put(id, UserDao.getUserFacultyNumber(id).getScore());
				
			}

			Map<String, Double> sortedMap = new HashMap<>();
			for (String courseid : temp.keySet()) {
				temp.get(courseid).entrySet().stream().sorted(Map.Entry.comparingByValue())
						.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
				;

				Map<String, Double> userc = temp.get(courseid);
				
				for (String uId : userc.keySet()) {

					if (result.get(courseid) == null) {
						List<String> useriDS = new ArrayList<String>();
						Integer cCount = tempUiserIdCourseMap.get(uId);
						if (cCount == null) {
							useriDS.add(uId);
							result.put(courseid, useriDS);
							tempUiserIdCourseMap.put(uId, 1);
						} else if (cCount < 2) {
							useriDS.add(uId);
							result.put(courseid, useriDS);
							tempUiserIdCourseMap.put(uId, 2);
						}
						
					} else if (result.get(courseid).size() < 2) {
						Integer cCount = tempUiserIdCourseMap.get(uId);
						if (cCount == null) {
							result.get(courseid).add(uId);
							tempUiserIdCourseMap.put(uId, 1);
						} else if (cCount < 2) {
							result.get(courseid).add(uId);
							tempUiserIdCourseMap.put(uId, 2);
						}
					}
				}

			}

		}

		return result;
	}

}
