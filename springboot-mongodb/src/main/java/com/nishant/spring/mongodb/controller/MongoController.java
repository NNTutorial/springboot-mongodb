package com.nishant.spring.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nishant.spring.mongodb.config.MongoConfigProperties;
import com.nishant.spring.mongodb.vo.User;

@RestController
@RequestMapping("/mongo")
public class MongoController {

	@Autowired
	private MongoConfigProperties mongoConfigProperties;

	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping(value="/add",method=RequestMethod.POST)
	public User add(@RequestBody User user) {
		mongoTemplate.insert(user, mongoConfigProperties.getCollectionname());
		return user;
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public User getbyid(@PathVariable Integer id) {
		return mongoTemplate.findById(id, User.class, mongoConfigProperties.getCollectionname());
	}
	
	@RequestMapping(value="/getall",method=RequestMethod.GET)
	public List<User> getall() {
		return mongoTemplate.findAll(User.class, mongoConfigProperties.getCollectionname());
	}
	
	@RequestMapping(value="/getcomp/{companyname}",method=RequestMethod.GET)
	public List<User> getbyid(@PathVariable String companyname) {
		Query q=new Query();
		q.addCriteria(Criteria.where("companyname").is(companyname));
		return mongoTemplate.find(q,User.class,mongoConfigProperties.getCollectionname());
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public User updatebyid(@RequestBody User user) {
		mongoTemplate.save(user, mongoConfigProperties.getCollectionname());
		return user;
	}
	
	@RequestMapping(value="/del/{id}",method=RequestMethod.DELETE)
	public User deletebyid(@PathVariable Integer id) {
		Query q=new Query();
		q.addCriteria(Criteria.where("id").is(id));
		return mongoTemplate.findAndRemove(q, User.class, mongoConfigProperties.getCollectionname());
	}

}
