package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecom.dao.ProductDAO;
import com.ecom.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductDAO productDao;
	/**
	 * Get Product List.
	 * @return
	 */
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView registratonMapping() {
		List<Product> products = productDao.getProducts();
		ModelAndView mv = new ModelAndView("products"); 
		mv.addObject("products", products);
		return mv;
	}
	
	/**
	 * Open Product create page.
	 * @return
	 */
	@RequestMapping(value="/open-product",method=RequestMethod.GET)
	public ModelAndView openAddProductPage() {
		ModelAndView modelAndView = new ModelAndView("add-product");
		Product product = new Product();
		modelAndView.addObject("product", product);
		return modelAndView;
	}
	
	/**
	 * Save Product Post Request.
	 * @param product
	 * @return
	 */
	@RequestMapping(value="/add-product",method=RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") Product product) {
		ModelAndView modelAndView = new ModelAndView("success-reponse");
		productDao.addProduct(product);
		modelAndView.addObject("action","created");
		return modelAndView;
	}
	
	/**
	 * Open Update Product page.
	 * @return
	 */
	@RequestMapping(value="/open-update",method=RequestMethod.GET)
	public ModelAndView openUpdateProductPage() {
		ModelAndView modelAndView = new ModelAndView("update-product");
		Product product = new Product();
		modelAndView.addObject("product", product);
		return modelAndView;
	}
	
	/**
	 * Save Update product info.
	 * @param product
	 * @return
	 */
	@RequestMapping(value="/update-product",method=RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute("product") Product product) {
		ModelAndView modelAndView = new ModelAndView("success-reponse");
		productDao.updateProduct(product);
		modelAndView.addObject("action","updated");
		return modelAndView;
	}
	
	/**
	 * Open delete page
	 * @return
	 */
	@RequestMapping(value="/open-delete",method=RequestMethod.GET)
	public ModelAndView openDeletetProductPage() {
		ModelAndView modelAndView = new ModelAndView("delete-product");
		Product product = new Product();
		modelAndView.addObject("product", product);
		return modelAndView;
	}
	
	/**
	 * Save delete action
	 * @param product
	 * @return
	 */
	@RequestMapping(value="/delete-product",method=RequestMethod.POST)
	public ModelAndView deleteProduct(@ModelAttribute("product") Product product) {
		ModelAndView modelAndView = new ModelAndView("success-reponse");
		modelAndView.addObject("action","deleted");
		productDao.deleteProduct(product);
		return modelAndView;
	}

}
