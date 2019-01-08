package com.wemakeprice.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wemakeprice.app.model.IndexReq;
import com.wemakeprice.app.model.IndexRes;
import com.wemakeprice.app.service.IndexService;

@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	IndexService indexService;
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index() {
		logger.info("index call");
		return "index";
	}
	
	@RequestMapping(value = "/indexAjax.do", method = RequestMethod.POST)
	public @ResponseBody IndexRes indexAjax(IndexReq req) {
		logger.info("indexAjax call");
		return indexService.indexAjax(req);
	}
}
 