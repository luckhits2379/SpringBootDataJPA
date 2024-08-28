package com.ng.springboot.datajpa.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ng.springboot.datajpa.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	// <introducer><subject><By><criteria> ie.public List<User>
	// findDistinctByNameIgnoreCaseAndCityIgnoreCase(String name, String city);
	// find is introducer,
	// Distinct is subject, which is optional,
	// By is separator between criteria and introducer,
	// Remaining is criteria. check doc for more available introducer and criteria.

	// custom finder or derived query methods
	public List<User> findByName(String name);

	// custom finder or derived query methods
	public List<User> findByNameIn(Collection<String> names);

	// custom finder or derived query methods
	public List<User> findDistinctByNameIgnoreCaseAndCityIgnoreCase(String name, String city);

	// Custom Query with JPQL
	@Query("Select u from User u")
	public List<User> getAllUsers();

	// Custom JPQL Query
	@Query("SELECT u FROM User u WHERE u.name = :name AND u.city = :city")
	public List<User> getUserUsingJPQL(String name, String city);

	// Custom Native SQL Query
	@Query(nativeQuery = true, value = "SELECT * FROM User u WHERE u.name = :name AND u.city = :city")
	public List<User> getUserUsingSQL(String name, String city);

}
