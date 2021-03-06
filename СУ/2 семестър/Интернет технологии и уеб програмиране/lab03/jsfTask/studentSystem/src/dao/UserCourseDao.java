package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserCourseDao {

	private static String fileName = "userCourse.txt";

	public static Map<String, String[]> getUserCoursesMap() {

		Map<String, String[]> result = new HashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(";");
				String facultyNumber = parts[0];
				String[] courseIds = parts[1].split(",");
				result.put(facultyNumber, courseIds);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	public static boolean hasSignedForCourses(String facultyNumber) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(";");
				String fn = parts[0];
				if (facultyNumber.equals(fn)) {
					return true;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public static void addCourses(String facultyNumber, List<String> courseIds) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));) {
			writer.append(facultyNumber);
			writer.append(";");
			writer.append(String.join(",", courseIds));
			writer.newLine();
			writer.flush();

			System.out.println("File write complete! Saved to: " + new File(fileName).getAbsolutePath());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
