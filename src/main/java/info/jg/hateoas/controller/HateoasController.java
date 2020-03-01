/**
 * 
 */
package info.jg.hateoas.controller;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.jg.hateoas.domain.Hateoas;
import lombok.val;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


/**
  * @FileName : HateoasController.java
  * @Project : springdemomvc
  * @Date : 2020. 3. 1. 
  * @작성자 : j
  * @변경이력 :
  * @프로그램 설명 :
  */
@RestController
@RequestMapping("/hateoas")
public class HateoasController {

	@GetMapping
	public Resource<Hateoas> hateoas() {
		val hateoas = Hateoas.builder()
			.prefix("Hello, ")
			.name("jglee")
			.build();
		Resource<Hateoas> hateoasResource = new Resource<>(hateoas);
		hateoasResource
			.add(linkTo(methodOn(HateoasController.class).hateoas()).withSelfRel());
		return hateoasResource;
	}
}
