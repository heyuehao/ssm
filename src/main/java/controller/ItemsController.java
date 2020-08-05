package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pojo.ItemsCustom;
import service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception {
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("itemsList");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/editItems",method = RequestMethod.GET)
	public String editItems(Model model, Integer id) throws Exception {
        // ��id����ҳ��
        model.addAttribute("id",id);

        // ����service��ѯ��Ʒ����Ϣ
        ItemsCustom itemsCustom=itemsService.findItemById(id);

        model.addAttribute("itemsCustom",itemsCustom);

        return "editItem";
    }
	
	@RequestMapping("/editItemSubmit")
	public String editItemSubmit(Model model, Integer id, ItemsCustom itemsCustom) throws Exception {
		// ���ݻ���
		model.addAttribute("id", id);
		
		// �������ݿ��е�����
		itemsService.updateItem(id, itemsCustom);
		
		return "redirect:queryItems.action";
	}
	
	//�Զ������Ա༭��
	/**
	 * ҳ���е����ڻ�ӳ�䵽ItemsCustom��Date������
	 * ���Ǵ�ҳ�洫�������������ַ�������
	 * ��ItemsCustom��������java.util.Date����
	 * 
	 * @param binder
	 * @throws Exception
	 */
    @InitBinder
    public void initBinder(WebDataBinder binder) throws  Exception{

        // Date.class��������controller�����β�pojo����һ�µ�date���ͣ�������java.util.Date
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"),true));
    }
}
