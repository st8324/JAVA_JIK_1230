package kr.kh.shoppingmall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "kr.kh.shoppingmall")
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Value("${spring.path.upload}")
	String uploadPath;

	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/file/**").addResourceLocations("file:///"+uploadPath);
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/");
	}
}
