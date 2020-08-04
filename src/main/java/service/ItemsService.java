package service;

import pojo.ItemsQueryVo;

import java.util.List;

import pojo.ItemsCustom;

public interface ItemsService {

	// 查询商品列表
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
