package com.wemakeprice.app.Utils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.wemakeprice.app.utils.HttpUtil;

public class HttpUtilTest {
	
	
	@Test
	public void getHttpUrlTestEmpty(){
		String html = HttpUtil.getContext("http://localhost:8080");
		assertThat(html, equalTo(""));
	}
	
	@Test
	public void getHttpUrlTest(){
		String html = HttpUtil.getContext("http://www.example.com");
		assertNotNull(html);
	}


}	
