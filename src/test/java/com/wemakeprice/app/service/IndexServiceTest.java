package com.wemakeprice.app.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.wemakeprice.app.model.IndexReq;
import com.wemakeprice.app.model.IndexRes;
import com.wemakeprice.app.utils.HttpUtil;

public class IndexServiceTest{
	
	private IndexService indexService;
	private IndexReq req;
	
	@Before
	public void setUp() throws Exception {
		indexService = new IndexServiceImp();
		
		req = new IndexReq();
		req.setUrl("http://www.example.com");
		req.setType("0");
		req.setLine(100);
	}

	@Test
	public void getContext() throws Exception {
		String text = HttpUtil.getContext(req.getUrl());
		assertNotNull(text);
		assertThat(text, not(equalTo("")));
	}
	
	
	@Test
	public void getQuotientAndRemainder() throws Exception {
		IndexRes res = indexService.indexAjax(req);
		
		String checkQuotient = "a0a0a0a0a0a0a0a0a0A0a0a1a1a2a3a4a5a5a6a7a8a8a8aaaaaaaaaaaaaaaaabbbbbbbbbccccccccccccDddddddddddddddd";
		String checkRemainder = "ddddddddDddddddEeeeeeeeeeeeeeeeeeeeEeeeeeeeeeeeeeeffffffffffffffffggggggggggHHhhhhhhhiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiikkkkkllllllllllllllllmmmmmmmmmmmmmmmmmmmmMmnnnnnnnNnnnnnnnnnnnnnnnnnnnnnnnooooooOoooooooooooooooooooooooooooooooooooppppppppppppprrrrrrrrrrrrrrrrrrrrrrrrrrrrrSssssssssssssssssssssstttttttttttttTttttttttttuuuuuuuuuuuuuuuvvvvvvwwwwxxxxxxxxxyyyYy";
		
		assertNotNull(res);
		assertThat(checkQuotient, equalTo(res.getQuotient()));
		assertThat(checkRemainder, equalTo(res.getRemainder()));
	}
	

}
