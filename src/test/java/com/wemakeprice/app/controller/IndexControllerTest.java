package com.wemakeprice.app.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.wemakeprice.app.model.IndexReq;
import com.wemakeprice.app.service.IndexServiceImp;


public class IndexControllerTest{
	
	private MockMvc mockMvc;
	private IndexReq req;
	
	
	@Before
	public void setup(){
		IndexController indexController = new IndexController();
		indexController.indexService = new IndexServiceImp();
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		
		req = new IndexReq();
		req.setUrl("http://www.example.com");
		req.setType("0");
		req.setLine(100);
	}
	
	@Test
	public void indexTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/index.do"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("index"));
		;
	}
	
	@Test
	public void getQuotientAndRemainderTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/indexAjax.do")
				.param("url", req.getUrl())
                .param("type", req.getType())
                .param("line", String.valueOf(req.getLine()))
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		;
	}



}
