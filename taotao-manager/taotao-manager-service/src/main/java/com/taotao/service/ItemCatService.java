package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EasyUTTreeNoda;

public interface ItemCatService {
	
	List<EasyUTTreeNoda> getItemCatList(long parentId);
}
