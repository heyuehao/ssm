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
        //将items的属性拷贝到itemsCustom
        BeanUtils.copyProperties(items, itemsCustom);

        return itemsCustom;
	}

	public void updateItem(Integer id, ItemsCustom itemsCustom) throws Exception{
		
		itemsMapper.updateItem(itemsCustom);
		
	}

	public void deleteItem(Integer id) throws Exception{
		
		itemsMapper.deleteItem(id);
	}

	public void insertItem(ItemsCustom itemsCustom) throws Exception {
		
		itemsMapper.insertItem(itemsCustom);
	}

	public List<ItemsCustom> findByName(String textValue) throws Exception {
		
		return itemsMapper.findByName(textValue);
	}

}
