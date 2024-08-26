package com.ng.springboot.datajpa;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ng.springboot.datajpa.entity.User;
import com.ng.springboot.datajpa.repository.UserRepository;

@SpringBootApplication
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootDataJpaApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		User user1 = new User();

		user1.setName("Nirmal");
		user1.setCity("Nagda");


		//Save Single Record
		System.out.println(userRepository.save(user1));


		User user2 = new User();

		user2.setName("Charan");
		user2.setCity("Dabdi");


		//Save Multiple Records
		Iterable<User> opList = userRepository.saveAll(List.of(user1, user2));

		opList.forEach(user -> {

			System.out.println(user);

		});


		//getData by id
		Optional<User> res = userRepository.findById(1);

		User user = res.get();

		System.out.println(user);


		//get all Data by id
		Iterable<User> allRes = userRepository.findAll();

		allRes.forEach(all_user -> {

			System.out.println(all_user);

		});
		
		//Delete Record
		userRepository.deleteById(1);


	}

}
