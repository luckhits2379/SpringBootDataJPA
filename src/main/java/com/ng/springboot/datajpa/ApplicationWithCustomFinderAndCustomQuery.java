package com.ng.springboot.datajpa;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ng.springboot.datajpa.entity.User;
import com.ng.springboot.datajpa.repository.UserRepository;

@SpringBootApplication
public class ApplicationWithCustomFinderAndCustomQuery {

	public static void main(String[] args) {

		// for more follow the link
		// https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#jpa.query-methods.query-creation

		ApplicationContext context = SpringApplication.run(ApplicationWithCustomFinderAndCustomQuery.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		List<User> userList = userRepository.findByName("Nirmal");

		for (User user : userList) {

			System.out.println(user);
		}

		System.out.println("-----------using IN--------");

		userList = userRepository.findByNameIn(List.of("Nirmal", "Charan"));

		for (User user : userList) {

			System.out.println(user);
		}

		System.out.println("-----------using multiple params--------");

		userList = userRepository.findDistinctByNameIgnoreCaseAndCityIgnoreCase("Nirmal", "Nagda");

		for (User user : userList) {

			System.out.println(user);
		}

		System.out.println("-----------Custom Query Method--------");

		userList = userRepository.getAllUsers();

		for (User user : userList) {

			System.out.println(user);
		}

		System.out.println("-----------Using JPQL--------");

		userList = userRepository.getUserUsingJPQL("Charan", "Dabdi");

		for (User user : userList) {

			System.out.println(user);
		}

		System.out.println("-----------Using  SQL--------");

		userList = userRepository.getUserUsingSQL("Nirmal", "Nagda");

		for (User user : userList) {

			System.out.println(user);
		}
	}

}
