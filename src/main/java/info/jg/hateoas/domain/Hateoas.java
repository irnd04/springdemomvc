/**
 * 
 */
package info.jg.hateoas.domain;

import lombok.Builder;
import lombok.Data;

/**
  * @FileName : Hateoas.java
  * @Project : springdemomvc
  * @Date : 2020. 3. 1. 
  * @작성자 : j
  * @변경이력 :
  * @프로그램 설명 :
  */
@Data
@Builder
public class Hateoas {
	private String prefix;
	private String name;
}
