package mapper;

import pojo.Items;

public interface ItemsMapper {

	// ����ID��ѯ��Ʒ
	public Items findItemById(Integer id) throws Exception;

	// ������Ʒ��Ϣ
	public void updateItem(Items item);
	
	
}
