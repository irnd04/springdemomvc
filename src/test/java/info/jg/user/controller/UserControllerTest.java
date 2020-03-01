package info.jg.user.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import info.jg.user.domain.User;
import lombok.val;

/**
  * @FileName : UserControllerTest.java
  * @Project : springdemomvc
  * @Date : 2020. 3. 1. 
  * @작성자 : j
  * @변경이력 :
  * @프로그램 설명 :
  */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper oMapper;
	
	@Test
	public void test() throws Exception {
		mockMvc.perform(get("/user"))
			.andExpect(status().isOk())
			.andExpect(content().string("user"))
			.andDo(print());
	}
	
	@Test
	public void createUserJson() throws Exception {
		val user = new User();
		user.setUsername("jglee");
		user.setPassword("0000");
		String userJson = oMapper.writeValueAsString(user);
		
		mockMvc.perform(post("/user/create")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(userJson))
			.andExpect(status().isOk())		
			.andExpect(jsonPath("$.username", is(equalTo("jglee"))))
			.andExpect(jsonPath("$.password", is(equalTo("0000"))))
			.andDo(print());
	}
	/*
	@Test
	public void createUserXML() throws Exception {
		val user = new User();
		user.setUsername("jglee");
		user.setPassword("0000");
		String userJson = oMapper.writeValueAsString(user);
		
		mockMvc.perform(post("/user/create")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_XML)
				.content(userJson))
			.andExpect(status().isOk())		
			.andExpect(xpath("/User/username").string("jglee"))
			.andExpect(xpath("/User/password").string("0000"))
			.andDo(print());
	}
	*/

}
