package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.User;
import model.UserType;

public class UserDao {

	private static Map<String, User> users;

//	static {
//		users = new HashMap<>();
//		users.put("ivant", new User("21501", "Ivan", "Todorov", 4.6, "ivant", "Abcd1234", UserType.STUDENT));
//		users.put("georgis", new User("21502", "Georgi", "Shopov", 5.3, "georgis", "Abcd1234", UserType.STUDENT));
//		users.put("petari", new User("21503", "Petar", "Ivanov", 6.0, "petari", "Abcd1234", UserType.STUDENT));
//		users.put("penkah", new User("21504", "Penka", "Hristova", 3.5, "penkah", "Abcd1234", UserType.STUDENT));
//		users.put("cvetelinaa",
//				new User("21505", "Cvetelina", "Angelova", 5.5, "cvetelinaa", "Abcd1234", UserType.STUDENT));
//		users.put("elenak", new User("21506", "Elena", "Karaivanova", 5.7, "elenak", "Abcd1234", UserType.STUDENT));
//		users.put("stefanq", new User("21507", "Stefan", "Qnev", 5.0, "stefanq", "Abcd1234", UserType.STUDENT));
//		users.put("aleksandrat",
//				new User("21508", "Aleksandra", "Todorova", 6.0, "aleksandrat", "Abcd1234", UserType.STUDENT));
//		users.put("svetlas", new User("21509", "Svetla", "Stoycheva", "svetlas", "Abcd1234", UserType.TEACHER));
//		users.put("hristoz", new User("21510", "Hrsito", "Zlatarev", "hristoz", "Abcd1234", UserType.TEACHER));
//	}
	
	static {
		loadUsers();
	}


	private static void loadUsers() {
		String fileName = "users.txt";

		users = new HashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 7) {
					String facultyNumber = parts[0];
					String firstName = parts[1];
					String lastnaME = parts[2];
					double score = Double.parseDouble(parts[3]);
					String userName = parts[4];
					String password = parts[5];
					UserType type = UserType.valueOf(parts[6]);

					users.put(userName, new User(facultyNumber, firstName, lastnaME, score, userName, password, type));
				} else {
					String facultyNumber = parts[0];
					String firstName = parts[1];
					String lastnaME = parts[2];
					String userName = parts[3];
					String password = parts[4];
					UserType type = UserType.valueOf(parts[5]);
					
					users.put(userName, new User(facultyNumber, firstName, lastnaME, userName, password, type));
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Collection<User>  getAllUsers() {
		return users.values();
	}

	public static User getUserByUserName(String userName) throws UserNotFoundException {
		User user = users.get(userName);

		if (user == null) {
			throw new UserNotFoundException(String.format("User with userName: %s does not exists.", userName));
		}
		return user;
	}

	public static User getUserFacultyNumber(String number) {

		for (User user : users.values()) {
			if (user.getFacultyNumber().equals(number)) {
				return user;
			}
		}

		return null;
	}

}
