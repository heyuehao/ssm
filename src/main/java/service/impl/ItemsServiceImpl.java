package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pojo.ItemsCustom;
import pojo.ItemsQueryVo;
import service.ItemsService;
import mapper.ItemsMapperCustom;

public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

}
