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
        // 将id传到页面
        model.addAttribute("id",id);

        // 调用service查询商品的信息
        ItemsCustom itemsCustom=itemsService.findItemById(id);

        model.addAttribute("itemsCustom",itemsCustom);

        return "editItem";
    }
	
	@RequestMapping("/editItemSubmit")
	public String editItemSubmit(Model model, Integer id, ItemsCustom itemsCustom) throws Exception {
		// 数据回显
		model.addAttribute("id", id);
		
		// 更新数据库中的数据
		itemsService.updateItem(id, itemsCustom);
		
		return "redirect:queryItems.action";
	}
	
	@RequestMapping("/deleteItemSubmit")
	public String deleteItem(Integer id) throws Exception {
		// 调用service删除商品
		itemsService.deleteItem(id);
		
		return "redirect:queryItems.action";
	}
	
	@RequestMapping("/addItem")
	public String addItem(Model model) throws Exception{
		model.addAttribute("createtime", new Date());
		
		return "addItem";
	}
	
	@RequestMapping("/addItemSubmit")
	public String addItemSubmit(ItemsCustom itemsCustom) throws Exception{
		
		// 调用service添加商品
		itemsService.insertItem(itemsCustom);
		
		return "redirect:queryItems.action";
	}
	
	//自定义属性编辑器
	/**
	 * 页面中的日期会映射到ItemsCustom的Date属性中
	 * 但是从页面传过来的日期是字符串类型
	 * 而ItemsCustom的属性是java.util.Date类型
	 * 
	 * @param binder
	 * @throws Exception
	 */
    @InitBinder
    public void initBinder(WebDataBinder binder) throws  Exception{

        // Date.class必须是与controller方法形参pojo属性一致的date类型，这里是java.util.Date
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"),true));
    }
}
