package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecom.dao.OrderDAO;
import com.ecom.dao.ProductUser;
import com.ecom.model.Order;

@Controller
public class OrderController {
	
	@Autowired
	OrderDAO orderDao;
	/**
	 * Get orders List.
	 * @return
	 */
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public ModelAndView registratonMapping() {
		List<Order> orders = orderDao.getOrders();
		ModelAndView mv = new ModelAndView("orders"); 
		mv.addObject("orders", orders);
		return mv;
	}
	
	/**
	 * Open Product create page.
	 * @return
	 */
	@RequestMapping(value="/add-order",method=RequestMethod.GET)
	public ModelAndView openAddProductPage() {
		ModelAndView modelAndView = new ModelAndView("add-order");
		modelAndView.addObject("productuser",  new ProductUser());
		return modelAndView;
	}
	
	/**
	 * Save Product Post Request.
	 * @param product
	 * @return
	 */
	@RequestMapping(value="/add-order",method=RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("productuser") ProductUser productuser) {			
		ModelAndView modelAndView = new ModelAndView("success-reponse");
		orderDao.addOder(productuser.getUserId(), productuser.getProductId());
		modelAndView.addObject("action","created");
		return modelAndView;
	}
	
}
