package service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pojo.Items;
import pojo.ItemsCustom;
import pojo.ItemsQueryVo;
import service.ItemsService;
import mapper.ItemsMapper;
import mapper.ItemsMapperCustom;

public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;

	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	public ItemsCustom findItemById(int id) throws Exception {
		Items items = itemsMapper.findItemById(id);
		ItemsCustom itemsCustom = new ItemsCustom();
        //��items�����Կ�����itemsCustom
        BeanUtils.copyProperties(items, itemsCustom);

        return itemsCustom;
	}

	public void updateItem(Integer id, ItemsCustom itemsCustom) {
		
		itemsMapper.updateItem(itemsCustom);
		
	}

}
