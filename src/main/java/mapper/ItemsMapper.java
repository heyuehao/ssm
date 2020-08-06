package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Items;
import pojo.ItemsCustom;

public interface ItemsMapper {

	// ����ID��ѯ��Ʒ
	public Items findItemById(Integer id) throws Exception;

	// ������Ʒ��Ϣ
	public void updateItem(Items item) throws Exception;

	// ɾ����Ʒ��Ϣ
	public void deleteItem(Integer id) throws Exception;

	// �����Ʒ��Ϣ
	public void insertItem(ItemsCustom itemsCustom) throws Exception;

	// ������Ʒ����ģ����ѯ
	public List<ItemsCustom> findByName(@Param(value="textValue")String textValue) throws Exception;
	
	
}
