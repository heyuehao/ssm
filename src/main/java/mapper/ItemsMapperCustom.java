package mapper;

import java.util.List;

import pojo.ItemsCustom;
import pojo.ItemsQueryVo;

public interface ItemsMapperCustom {

	// ��ѯ��Ʒ�б�
	List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
}
