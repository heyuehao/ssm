package service;

import pojo.ItemsQueryVo;

import java.util.List;

import pojo.ItemsCustom;

public interface ItemsService {

	// 查询商品列表
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
    
    // 通过id查找商品
    public ItemsCustom findItemById(int id) throws Exception;

    // 更新商品信息
	public void updateItem(Integer id, ItemsCustom itemsCustom) throws Exception;
	
	// 删除商品信息
	public void deleteItem(Integer id) throws Exception;
	
	// 添加商品信息
	public void insertItem(ItemsCustom itemsCustom) throws Exception;
}
