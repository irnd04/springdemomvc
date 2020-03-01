package info.jg.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.jg.user.domain.User;

/**
  * @FileName : UserController.java
  * @Project : springdemomvc
  * @Date : 2020. 3. 1. 
  * @작성자 : j
  * @변경이력 :
  * @프로그램 설명 :
  */
@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	/**
	  * @Method Name : user
	  * @작성일 : 2020. 3. 1.
	  * @작성자 : j
	  * @변경이력 : 
	  * @Method 설명 :
	  * @return
	  */
	@GetMapping
	public String user() {
		return "user";
	}
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return user;
	}
}
