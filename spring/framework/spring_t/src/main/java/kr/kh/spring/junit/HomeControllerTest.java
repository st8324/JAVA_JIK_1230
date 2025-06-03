package kr.kh.spring.junit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import kr.kh.spring.controller.HomeController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/main/webapp/WEB-INF/spring/mybatis-config.xml",
	"file:src/main/webapp/WEB-INF/spring/spring-security.xml"
})
public class HomeControllerTest {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before

	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void signupTest() {
		try {
			mockMvc.perform(
				post("/signup")
				.param("me_id", "456")
				.param("me_pw", "456")
				.param("me_email","456@naver.com"))
			.andDo(print())
			.andExpect(status().isOk());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}
}
