package mapper;

import pojo.Items;

public interface ItemsMapper {

	// 根据ID查询商品
	public Items findItemById(Integer id) throws Exception;

	// 更新商品信息
	public void updateItem(Items item);
	
	
}
