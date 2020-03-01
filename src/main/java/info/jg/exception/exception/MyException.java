/**
 * 
 */
package info.jg.exception.exception;

/**
  * @FileName : MyException.java
  * @Project : springdemomvc
  * @Date : 2020. 3. 1. 
  * @작성자 : j
  * @변경이력 :
  * @프로그램 설명 :
  */
public class MyException extends Exception {

	/**
	 * @param string
	 */
	public MyException(String s) {
		super(s);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
