package com.wemakeprice.app.Utils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.wemakeprice.app.utils.StringUtil;


public class StringUtilTest {
	
	private String html;
	
	@Before
	public void setUp() throws Exception {
		html = "<body>\r\n" + "<h1>\r\n" + "	Hello world!  \r\n" + "</h1>\r\n" + "\r\n"
				+ "<P> 안녕하세요.  ${serverTime}. 2019.01.08 �Դϴ�. </P>\r\n" + "<P> A0a1234h37zZgHa </P>\r\n" + "</body>";
	}
	
	
	@Test
	public void trimAll() throws IOException{
		String result = StringUtil.trimAll(html);
		String check = "<body><h1>Helloworld!</h1><P>안녕하세요.${serverTime}.2019.01.08�Դϴ�.</P><P>A0a1234h37zZgHa</P></body>";
		
		assertNotNull(result);
		assertThat(result, equalTo(check));
	}
	
	@Test
	public void removeTag() throws IOException{
		String result = StringUtil.trimAll(StringUtil.removeTag(html));
		String check = "Helloworld!안녕하세요.${serverTime}.2019.01.08�Դϴ�.A0a1234h37zZgHa";
		
		assertNotNull(result);
		assertThat(result, equalTo(check));
	}
	
	@Test
	public void getEng() throws IOException{
		String result = StringUtil.trimAll(StringUtil.english(StringUtil.removeTag(html)));
		String check = "HelloworldserverTimeAahzZgHa";
		
		assertNotNull(result);
		assertThat(result, equalTo(check));
	}
	
	@Test
	public void getNum() throws IOException{
		String result = StringUtil.trimAll(StringUtil.number(StringUtil.removeTag(html)));
		String check = "201901080123437";
		
		assertNotNull(result);
		assertThat(result, equalTo(check));
	}
	
	
	@Test
	public void engSort() throws IOException{
		String result = StringUtil.sort(StringUtil.trimAll(StringUtil.english(StringUtil.removeTag(html))));
		String check = "AaadeeeegHhHilllmoorrrsTvwzZ";
		
		assertNotNull(result);
		assertThat(result, equalTo(check));
	}
	
	@Test
	public void numSort() throws IOException{
		String result = StringUtil.sort(StringUtil.trimAll(StringUtil.number(StringUtil.removeTag(html))));
		String check = "000011122334789";
		assertThat(result, equalTo(check));
	}
	
	@Test
	public void mix() throws IOException{
		String result1 = StringUtil.sort(StringUtil.trimAll(StringUtil.english(StringUtil.removeTag(html))));
		String result2 = StringUtil.sort(StringUtil.trimAll(StringUtil.number(StringUtil.removeTag(html))));
		String check = "A0a0a0d0e1e1e1e2g2H3h3H4i7l8l9lmoorrrsTvwzZ";
		
		assertNotNull(result1);
		assertNotNull(result2);

		assertThat(StringUtil.mix(result1, result2) , equalTo(check));
	}
	

}	
