/**
 * 
 */
package info.jg.sample.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import lombok.val;

/**
  * @FileName : SampleControllerTest.java
  * @Project : springdemomvc
  * @Date : 2020. 3. 1. 
  * @작성자 : j
  * @변경이력 :
  * @프로그램 설명 :
  */

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebClient wc;

	@Test
	public void test() throws Exception {
		mockMvc.perform(get("/sample"))
			.andExpect(status().isOk())
			.andExpect(view().name("sample"))
			.andExpect(model().attribute("name", "jglee"))		
			.andExpect(content().string(containsString("jglee")));
	}
	
	@Test
	public void webClientTest() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		HtmlPage page = wc.getPage("/sample");
		// HtmlHeading1 h1 = page.getFirstByXPath("//h1");
		DomNode h1 = page.querySelector("h1");
		assertThat(h1.getTextContent()).isEqualToIgnoringCase("jglee");
	}

}
