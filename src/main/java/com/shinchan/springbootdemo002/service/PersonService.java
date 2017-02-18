package com.shinchan.springbootdemo002.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shinchan.springbootdemo002.bean.Person;


public interface PersonService extends JpaRepository<Person, Serializable> {
	
	List<Person> findByAge(int age);

}
