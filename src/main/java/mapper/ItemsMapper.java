package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Items;
import pojo.ItemsCustom;

public interface ItemsMapper {

	// 根据ID查询商品
	public Items findItemById(Integer id) throws Exception;

	// 更新商品信息
	public void updateItem(Items item) throws Exception;

	// 删除商品信息
	public void deleteItem(Integer id) throws Exception;

	// 添加商品信息
	public void insertItem(ItemsCustom itemsCustom) throws Exception;

	// 根据商品名称模糊查询
	public List<ItemsCustom> findByName(@Param(value="textValue")String textValue) throws Exception;
	
	
}
