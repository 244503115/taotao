package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.utils.TaotaoResult;

public interface ItemParamService {
	
	TaotaoResult getItemParamByCid(long cid);
	
	TaotaoResult insertItemParam(TbItemParam itemParam);
	
	EUDataGridResult getItemParamList(Integer page,Integer rows) throws Exception;
	
	
}
