package com.shinchan.springbootdemo002.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shinchan.springbootdemo002.bean.Person;
import com.shinchan.springbootdemo002.service.PersonService;
import com.shinchan.springbootdemo002.service.TranService;


@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private TranService tranService;

	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	@GetMapping(value = "/person")
	public List<Person> getPersonList() {
		return personService.findAll();
	}

	/**
	 * 添加用户信息
	 * 
	 * @param person
	 * @return
	 */
	@PostMapping("/person")
	public Person savePerson(Person person) {
		return personService.save(person);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param person
	 * @return
	 */
	@PutMapping("/person/{id}")
	public Person updatePerson(@PathVariable("id") int pId, Person person) {
		person.setId(pId);
		return personService.save(person);
	}

	/**
	 * 查询一个用户
	 * 
	 * @param pId
	 * @return
	 */
	@GetMapping("/person/{id}")
	public Person findOnePerson(@PathVariable("id") int pId) {
		return personService.findOne(pId);
	}

	/**
	 * 根据id删除用户
	 * 
	 * @param pId
	 */
	@DeleteMapping("/person/{id}")
	public void delPerson(@PathVariable("id") int pId) {
		personService.delete(pId);
	}

	/**
	 * 删除全部用户
	 * 
	 * @param pId
	 */
	@DeleteMapping("/person")
	public void delAllPerson() {
		personService.deleteAll();
	}
	
	/**
	 * 根据年龄查询
	 * @param age
	 * @return
	 */
	@GetMapping("/person/age/{age}")
	public List<Person> ListByAge(@PathVariable("age") int age){
		return personService.findByAge(age);
	}
	
	@PostMapping("/person/two")
	public void addTwoPerson(){
		tranService.addTwoPerson();
	}

}
