/**
 * 
 */
package info.jg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
  * @FileName : WebConfig.java
  * @Project : springdemomvc
  * @Date : 2020. 3. 1. 
  * @작성자 : j
  * @변경이력 :
  * @프로그램 설명 :
  */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/o/**")
			.addResourceLocations("classpath:/o/")
			.setCachePeriod(20);
	}
	
}
