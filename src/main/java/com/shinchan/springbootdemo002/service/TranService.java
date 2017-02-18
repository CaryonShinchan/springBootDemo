package com.shinchan.springbootdemo002.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shinchan.springbootdemo002.bean.Person;

@Service
public class TranService {

	@Autowired
	private PersonService ps;
	
	@Transactional
	public void addTwoPerson(){
		Person p1 = new Person();
		p1.setName("李大宝");
		p1.setPhone("123456633");
		p1.setAge(24);
		ps.save(p1);
		
		Person p2 = new Person();
		p2.setName("绿铅笔");
		p2.setPhone("234521232322222222");
		p2.setAge(29);
		ps.save(p2);
	}
}
