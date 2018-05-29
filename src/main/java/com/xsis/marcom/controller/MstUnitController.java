package com.xsis.marcom.controller;

import java.util.Collection;
import java.util.Date;

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

import com.xsis.marcom.model.MstUnitModel;
import com.xsis.marcom.service.MstUnitService;

@Controller
public class MstUnitController {
	
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private MstUnitService service;
	
	@RequestMapping(value="/master/msunit")
	public ModelAndView msunitIndex(Model model) {
		return new ModelAndView("/master/msunit");
	}
	
	@RequestMapping(value = "/master/msunit/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		Collection<MstUnitModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/msunit/list");
	}

	@RequestMapping(value = "/master/msunit/search", method = RequestMethod.GET)
	public ModelAndView search(Model model, HttpServletRequest request) {
		String keySearch = request.getParameter("key");
		Collection<MstUnitModel> result = null;
		try {
			result = this.service.search(keySearch);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/msunit/list");
	}

	@RequestMapping(value = "/master/msunit/add", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		return new ModelAndView("/master/msunit/add");
	}

	@RequestMapping(value = "/master/msunit/edit")
	public ModelAndView edit(Model model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		MstUnitModel result = new MstUnitModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);
		
		return new ModelAndView("/master/msunit/edit");
	}

	@RequestMapping(value = "/master/msunit/delete")
	public ModelAndView delete(Model model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		MstUnitModel result = new MstUnitModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/master/msunit/delete");
	}

	@RequestMapping(value = "/master/msunit/save")
	public String save(Model model, @ModelAttribute MstUnitModel item, HttpServletRequest request) {
		String result = "";
		String action = request.getParameter("action");
		MstUnitModel tmp = null;
		try {
			
			tmp = this.service.getById(item.getId());

			if (action.equals("insert")) {
				item.setCreatedDate(new Date());
				item.setUpdatedDate(new Date());
				item.setCreatedBy(new String("admin"));
				item.setUpdatedBy(new String("admin"));
				item.setIsDelete(0);
				this.service.insert(item);
			} else if (action.equals("update")){
				item.setCreatedDate(new Date());
				item.setUpdatedDate(new Date());
				item.setCreatedBy(new String("admin"));
				item.setUpdatedBy(new String("admin"));
				item.setIsDelete(0);
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

		return "/master/msunit/save";
	}
	

}
