package com.wemakeprice.app.service;

import com.wemakeprice.app.model.IndexReq;
import com.wemakeprice.app.model.IndexRes;

public interface IndexService {
	public IndexRes indexAjax(IndexReq req);
}
