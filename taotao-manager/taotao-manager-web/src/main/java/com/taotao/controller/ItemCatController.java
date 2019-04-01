package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//商品分类管理Controller
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUTTreeNoda;
import com.taotao.service.ItemCatService;
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUTTreeNoda> getItemCatList(@RequestParam(value="id", defaultValue="0")Long parentId){
		List<EasyUTTreeNoda> list = itemCatService.getItemCatList(parentId);
		return list;
	}
}
