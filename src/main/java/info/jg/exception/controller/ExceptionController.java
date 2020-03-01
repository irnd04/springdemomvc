/**
 * 
 */
package info.jg.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import info.jg.exception.error.MyError;
import info.jg.exception.exception.MyException;
import lombok.val;

/**
  * @FileName : ExceptionController.java
  * @Project : springdemomvc
  * @Date : 2020. 3. 1. 
  * @작성자 : j
  * @변경이력 :
  * @프로그램 설명 :
  */
@Controller
@RequestMapping(value = "/exception")
public class ExceptionController {
	
	@GetMapping
	public String exception() throws MyException {
		throw new MyException("myerror");
	}
	
	@ExceptionHandler(value = {MyException.class})
	public @ResponseBody MyError myExceptionHandler(MyException e) {
		val r = MyError.builder()
				.message(e.getMessage())
				.reason("reason..")
				.build();
		return r;
	}
	
}
