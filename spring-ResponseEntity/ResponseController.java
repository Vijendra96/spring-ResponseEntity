package com.man.demon;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {

	@GetMapping("service1")
	ResponseEntity<String> service1()
	{
		ResponseEntity<String> responseEntuty = new ResponseEntity<String>("seccessfully done", HttpStatus.OK);
		return responseEntuty ;
	}
	
	@RequestMapping("service2/")
	ResponseEntity<List<String>> service2()
	{
		List list = new ArrayList<String>();
		list.add("vijendra");
		list.add("kharwar");
		list.add("25");
		ResponseEntity<List<String>> responseEntity =  new ResponseEntity<List<String>>(list,HttpStatus.OK);
		return responseEntity;
	}
	
	
	@RequestMapping("service3/")
	ResponseEntity<Person> service3()
	{
		Person person = new Person();
		person.setFirstName("vijendra");
		person.setSecondName("kharwar");
		person.setAge(25);
		ResponseEntity<Person> responseEntity =  new ResponseEntity<Person>(person,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping("service4/{age}")
	ResponseEntity<String> service4(@PathVariable Integer age)
	{
		ResponseEntity<String> responseEntity = null;
		if(age <= 0)
		{
			responseEntity = new ResponseEntity<String>("age should not be 0 or negative",HttpStatus.BAD_REQUEST);
		}
		else
		{
			responseEntity = new ResponseEntity<String>("your age is " + age, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	
	@RequestMapping("service5/{age}")
	ResponseEntity<String> service5(@PathVariable Integer age)
	{
		ResponseEntity<String> responseEntity = null;
		if(age <= 0)
		{
			responseEntity = ResponseEntity.badRequest().body("age should not be 0 or negative");
		}
		else
		{
			responseEntity = ResponseEntity.ok().body("your age is " + age);
		}
		return responseEntity;
	}
}
