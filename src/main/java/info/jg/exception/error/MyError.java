/**
 * 
 */
package info.jg.exception.error;

import lombok.Builder;
import lombok.Data;

/**
  * @FileName : MyError.java
  * @Project : springdemomvc
  * @Date : 2020. 3. 1. 
  * @작성자 : j
  * @변경이력 :
  * @프로그램 설명 :
  */
@Data
@Builder
public class MyError {
	private String message;
	private String reason;
}
