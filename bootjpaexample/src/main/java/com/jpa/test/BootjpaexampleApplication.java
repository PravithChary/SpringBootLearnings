package com.jpa.test;

import com.jpa.test.dao.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.jpa.test.entities.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		/*
		User user = new User();
		user.setName("Pravith Chary");
		user.setCity("Pune");
		user.setStatus("I am a java developer");*/

		User user1 = new User();
		user1.setName("Name1");
		user1.setCity("City 1");
		user1.setStatus("Python Dev");

		User user2 = new User();
		user2.setName("Name 2");
		user2.setCity("City 2");
		user2.setStatus("C++ Dev");

		ArrayList<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);

		// Only for single user
		// User user3 = userRepository.save(user2);
		// System.out.println(user3);

		// Save multiple objects
		Iterable<User> result = userRepository.saveAll(users);
		for(User u:result){
			System.out.println(u);
		}

		// Update the user
		/*Optional <User> optional = userRepository.findById(1);
		User user = optional.get();

		user.setName("Pravit");

		User result = userRepository.save(user);
		System.out.println(result);*/

		// Getting the data
		// findById(id) - return Optional Containing your data
//		Iterable<User>itr = userRepository.findAll();
//		Iterator<User> iterator = itr.iterator();
//		while(iterator.hasNext()){
//			User user = iterator.next();
//			System.out.println(user);
//		}
//		itr.forEach(user -> {
//			System.out.println(user);
//		});

		// Deleting user element
//		userRepository.deleteById(53);
//		System.out.println("deleted");

//		Iterable <User> allUsers = userRepository.findAll();
//		allUsers.forEach(user -> System.out.println(user));
//		userRepository.deleteAll(allUsers);
		List <User> usersByName = userRepository.findByName("Name1");
		usersByName.forEach(e-> System.out.println(e));

	}

}
