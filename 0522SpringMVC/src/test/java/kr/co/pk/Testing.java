package kr.co.pk;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/**/*.xml"
})
public class Testing {
	//웹 애플리케이션 컨텍스트 : spring 설정 파일 객체
	@Autowired
	private WebApplicationContext wac;
	//url을 실행해보기 위한 클래스의 변수 
	private MockMvc mockMvc;
	
	//테스트 하기 전에 수행 
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testMethod() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"));
	}
}
