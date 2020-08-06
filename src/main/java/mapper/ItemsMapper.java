package mapper;

import pojo.Items;
import pojo.ItemsCustom;

public interface ItemsMapper {

	// ����ID��ѯ��Ʒ
	public Items findItemById(Integer id) throws Exception;

	// ������Ʒ��Ϣ
	public void updateItem(Items item);

	// ɾ����Ʒ��Ϣ
	public void deleteItem(Integer id);

	// �����Ʒ��Ϣ
	public void insertItem(ItemsCustom itemsCustom);
	
	
}
