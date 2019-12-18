package com.eshop.controllers;


import org.hibernate.engine.spi.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eshop.dao.ProductDao;
import com.eshop.model.Product;


@Controller
public class AddProduct {

	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value="/addProduct",method=RequestMethod.GET)
	public String AddProducts(ModelMap map) {
		
		map.addAttribute("product", "Add Product Here");
		map.addAttribute("productObj", new Product());
		return "AddProduct";
	}
	
	@RequestMapping(value = "/AddProduct", method = RequestMethod.POST)
	public ModelAndView ProductDetail(@ModelAttribute("productObj") Product productObj) {
			productDao.addProduct(productObj);
			ModelAndView mv = new ModelAndView("AddProduct");
			mv.addObject("msg","added");
				return mv;
		}

}
