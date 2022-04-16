package courses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="courseService")
@ApplicationScoped
public class CourseService {

    private static List<Course> courses;

//    static {
//    	
//        courses = new ArrayList<>();
//        courses.add(new Course("C01", "Семантичен Уеб","доц. д-р Светла Николова Бойчева", 5));
//        courses.add(new Course("C02", "Интернет технологии и уеб програмиране", "доц. д-р Милен Йорданов Петров	", 5));
//        courses.add(new Course("C03", "Софтуерни технологии 2 (проект)", "проф. д-р Силвия Христова Илиева", 6));
//        courses.add(new Course("C04", "Модели на софтуерни системи", "проф. д-р Олга Илиева Георгиева", 5));
//    }
//    
    
    static { 
    	readInitialCourses();
    }
    
    private static void readInitialCourses() {
    	String fileName = "course.txt";
		courses = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				String id = parts[0];
				String name = parts[1];
				String teacher = parts[2];
				int credits = Integer.parseInt(parts[3]);
				
				courses.add(new Course(id, name, teacher, credits));
				
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }
    
    public static Course getCourseById(String id) {
    	for(Course course: courses) {
    		if (course.getId().equals(id)) {
    			return course;
    		}
    	}
    	
    	return null;
    }


	public List<Course> getClonedCourses() {
		List<Course> results = new ArrayList<>();
		List<Course> originals = getCourses();
		for (Course original : originals) {
			results.add(original.clone());
		}
		return results;
	}
}