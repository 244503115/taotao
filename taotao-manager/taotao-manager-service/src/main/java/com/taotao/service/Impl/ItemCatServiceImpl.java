package com.taotao.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUTTreeNoda;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;


//商品分类管理
@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public List<EasyUTTreeNoda> getItemCatList(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		//设置查询条件
		 Criteria criteria = example.createCriteria();
		//根据parentid查询子节点
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		//转换成EasyUTTreeNoda列表
		List<EasyUTTreeNoda> resultList = new ArrayList();
		for(TbItemCat tbItemCat:list) {
			//创建一个节点对象
			EasyUTTreeNoda node = new EasyUTTreeNoda();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			//添加到列表中
			resultList.add(node);
		}
		return resultList;
	}

}
