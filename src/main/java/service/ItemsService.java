package service;

import pojo.ItemsQueryVo;

import java.util.List;

import pojo.ItemsCustom;

public interface ItemsService {

	// ��ѯ��Ʒ�б�
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
    
    // ͨ��id������Ʒ
    public ItemsCustom findItemById(int id) throws Exception;

    // ������Ʒ��Ϣ
	public void updateItem(Integer id, ItemsCustom itemsCustom);
}
