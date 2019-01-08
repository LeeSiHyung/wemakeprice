package com.wemakeprice.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wemakeprice.app.model.IndexReq;
import com.wemakeprice.app.model.IndexRes;
import com.wemakeprice.app.utils.HttpUtil;
import com.wemakeprice.app.utils.StringUtil;

@Service
public class IndexServiceImp implements IndexService{
	
	private static final Logger logger = LoggerFactory.getLogger(IndexServiceImp.class);

	@Override
	public IndexRes indexAjax(IndexReq req) {
		
		String contents = HttpUtil.getContext(req.getUrl());
		
		if(IndexReq.TEXT_TYPE.equals(req.getType())) 
			contents = StringUtil.removeTag(contents);
		
		String eng = StringUtil.trimAll(StringUtil.english(contents));
		String num = StringUtil.trimAll(StringUtil.number(contents));
		
		logger.info("영어만 출력 : " + eng);
		logger.info("숫자만 출력 : " + num);
		
		eng = StringUtil.sort(eng);
		num = StringUtil.sort(num);
		
		logger.info("영어 오름차순으로 출력 : " + eng);
		logger.info("숫자 오름차순으로 출력: " + num);
		
		eng = StringUtil.sort(eng);
		num = StringUtil.sort(num);
		
		String mix = StringUtil.mix(eng, num);
		logger.info("mix 교차 출력 : " + mix);
		
		return new IndexRes(req.getLine(), mix);
	}
	
}
