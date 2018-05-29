package com.xsis.marcom.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.marcom.model.MstProductModel;
import com.xsis.marcom.service.MstProductService;

@Controller
public class MstProductController {
	
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private MstProductService service;
	
	@RequestMapping(value="/master/product")
	public ModelAndView productIndex(Model model) {
		return new ModelAndView("/master/product");
	}
	
	@RequestMapping(value = "/master/product/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		Collection<MstProductModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/product/list");
	}

	@RequestMapping(value = "/master/product/search", method = RequestMethod.GET)
	public ModelAndView search(Model model, HttpServletRequest request) {
		String keySearch = request.getParameter("key");
		Collection<MstProductModel> result = null;
		try {
			result = this.service.search(keySearch);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/product/list");
	}

	@RequestMapping(value = "/master/product/add", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		return new ModelAndView("/master/product/add");
	}

	@RequestMapping(value = "/master/product/edit")
	public ModelAndView edit(Model model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		MstProductModel result = new MstProductModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/master/product/edit");
	}

	@RequestMapping(value = "/master/product/delete")
	public ModelAndView delete(Model model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		MstProductModel result = new MstProductModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/master/product/delete");
	}

	@RequestMapping(value = "/master/product/save")
	public String save(Model model, @ModelAttribute MstProductModel item, HttpServletRequest request) {
		String result = "";
		String action = request.getParameter("action");
		MstProductModel tmp = null;
		try {
			
			tmp = this.service.getById(item.getId());

			if (action.equals("insert")) {				
				this.service.insert(item);
			} else if (action.equals("update")){
				this.service.update(item);
			}				
			else if (action.equals("delete"))
				this.service.delete(tmp);

			result = "success";

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result = "failed";
		}

		model.addAttribute("message", result);

		return "/master/product/save";
	}
	

}
