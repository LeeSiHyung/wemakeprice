package com.wemakeprice.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.wemakeprice.app.controller.IndexController;
import com.wemakeprice.app.service.IndexService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class TestContextTests {

    @Autowired
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;

    
    @Autowired
    IndexController indexController;
    
    @Autowired
	IndexService indexService;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void controllerCheck() {
		assertNotNull(indexController);
	}
	
	@Test
	public void serviceCheck() {
		assertNotNull(indexService);
	}


}
