package mapper;

import pojo.Items;
import pojo.ItemsCustom;

public interface ItemsMapper {

	// 根据ID查询商品
	public Items findItemById(Integer id) throws Exception;

	// 更新商品信息
	public void updateItem(Items item);

	// 删除商品信息
	public void deleteItem(Integer id);

	// 添加商品信息
	public void insertItem(ItemsCustom itemsCustom);
	
	
}
