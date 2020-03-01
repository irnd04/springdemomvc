/**
 * 
 */
package info.jg.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
  * @FileName : SampleController.java
  * @Project : springdemomvc
  * @Date : 2020. 3. 1. 
  * @작성자 : j
  * @변경이력 :
  * @프로그램 설명 :
  */

@Controller
@RequestMapping(value = "/sample")
public class SampleController {
	
	@GetMapping(value = "")
	public String sample(Model model) {
		model.addAttribute("name", "jglee");
		return "sample";
	}
	
}
