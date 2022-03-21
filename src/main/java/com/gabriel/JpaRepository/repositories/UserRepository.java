package com.gabriel.JpaRepository.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gabriel.JpaRepository.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);

	@Query("SELECT obj FROM User obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
	Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
