/**
 * 
 */
package info.jg.hateoas.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
  * @FileName : HateoasControllerTest.java
  * @Project : springdemomvc
  * @Date : 2020. 3. 1. 
  * @작성자 : j
  * @변경이력 :
  * @프로그램 설명 :
  */
@RunWith(SpringRunner.class)
@WebMvcTest(HateoasController.class)
public class HateoasControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test() throws Exception {
		mockMvc.perform(get("/hateoas"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$._links.self").exists())
			.andDo(print());
	}

}
