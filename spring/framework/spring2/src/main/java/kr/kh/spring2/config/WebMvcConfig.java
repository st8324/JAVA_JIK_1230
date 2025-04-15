package kr.kh.spring2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import kr.kh.spring2.interceptor.AutoLoginInterceptor;
import kr.kh.spring2.interceptor.LoginInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "kr.kh.spring2") 
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	LoginInterceptor loginInterceptor;
	@Autowired
	AutoLoginInterceptor autoLoginInterceptor;
	
	
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/download/**").addResourceLocations("file:///D:/uploads/");
    }
    
	// TilesViewResolver 설정
    @Bean
    public TilesViewResolver tilesViewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setOrder(1); // ViewResolver의 우선순위 설정
        return tilesViewResolver;
    }
    // Tiles 설정
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/spring/tiles-def.xml");
        tilesConfigurer.setCheckRefresh(true); // 변경 사항을 자동으로 감지하여 갱신
        return tilesConfigurer;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/login"); 
        //AutoLoginInterceptor를 연결
        registry.addInterceptor(autoLoginInterceptor)
        		.addPathPatterns("/**"); 
    }
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();  // BCryptPasswordEncoder 빈 등록
	}
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(10* 1024 * 1024);
		return resolver;
	}
}