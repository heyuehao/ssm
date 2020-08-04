package mapper;

import java.util.List;

import pojo.ItemsCustom;
import pojo.ItemsQueryVo;

public interface ItemsMapperCustom {

	// 查询商品列表
	List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
