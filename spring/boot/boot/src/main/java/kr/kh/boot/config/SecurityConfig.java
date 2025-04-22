package kr.kh.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import kr.kh.boot.model.vo.UserRole;
import kr.kh.boot.service.MemberDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

	@Autowired
	private MemberDetailService memberDetailService;
	
	@Value("${security.rememberme.key}")
	private String rememberMeKey;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf ->csrf.disable())
			.authorizeHttpRequests((requests) -> requests
			//회원과 관리자가 접근할 수 있는 URL(MemberInterceptor 역할)
			.requestMatchers("/post/insert/*","/post/update/*", "/post/delete/*")
			.hasAnyAuthority(UserRole.USER.name(), UserRole.ADMIN.name())
			//관리자만 접근할 수 있는 URL(AdminInterceptor 역할)
			.requestMatchers("/admin/**")
			.hasAnyAuthority(UserRole.ADMIN.name())
			
			.anyRequest()
			.permitAll()  // 그 외 요청은 인증 필요
			)
			//로그인 처리
			.formLogin((form) -> form
				.loginPage("/login")  // 커스텀 로그인 페이지 설정. 사용 안하면 스프링에서 제공하는 기본 화면이 나옴
				.permitAll()           // 로그인 페이지는 접근 허용
				.loginProcessingUrl("/login")//로그인 화면에서 로그인을 눌렀을 때 처리할 url을 지정
				.defaultSuccessUrl("/")//로그인 성공 후 보낼 URL
			)
			//자동 로그인 처리
			.rememberMe(rm-> rm
				.userDetailsService(memberDetailService)//자동 로그인할 때 사용할 userDetailService를 추가
				.key(rememberMeKey)//키가 변경되면 기존 토큰이 무효처리
				.rememberMeCookieName("LC")//쿠키 이름
				.tokenValiditySeconds(60 * 60 * 24 * 7)//유지 기간 : 7일
			)
			//로그아웃 처리. 등록된 url에 post 방식으로 요청이 온 경우 자동으로 로그아웃 처리
			.logout((logout) -> logout
				.logoutUrl("/logout")//로그아웃을 처리할 URL 지정. post방식
				.logoutSuccessUrl("/")//로그아웃 후 URL
				.clearAuthentication(true)
				.invalidateHttpSession(true)
				.permitAll());  // 로그아웃도 모두 접근 가능
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}