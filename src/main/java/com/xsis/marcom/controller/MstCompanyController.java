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

import com.xsis.marcom.model.MstCompanyModel;
import com.xsis.marcom.service.MstCompanyService;

@Controller
public class MstCompanyController {
	
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private MstCompanyService service;
	
	@RequestMapping(value="/master/company")
	public ModelAndView CompanyIndex(Model model) {
		return new ModelAndView("/master/company");
	}
	
	@RequestMapping(value = "/master/company/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		Collection<MstCompanyModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/company/list");
	}

	@RequestMapping(value = "/master/company/search", method = RequestMethod.GET)
	public ModelAndView search(Model model, HttpServletRequest request) {
		String keySearch = request.getParameter("key");
		Collection<MstCompanyModel> result = null;
		try {
			result = this.service.search(keySearch);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/company/list");
	}

	@RequestMapping(value = "/master/company/add", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		return new ModelAndView("/master/company/add");
	}

	@RequestMapping(value = "/master/company/edit")
	public ModelAndView edit(Model model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		MstCompanyModel result = new MstCompanyModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);
		
		return new ModelAndView("/master/company/edit");
	}

	@RequestMapping(value = "/master/company/delete")
	public ModelAndView delete(Model model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		MstCompanyModel result = new MstCompanyModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/master/company/delete");
	}

	@RequestMapping(value = "/master/company/save")
	public String save(Model model, @ModelAttribute MstCompanyModel item, HttpServletRequest request) {
		String result = "";
		String action = request.getParameter("action");
		MstCompanyModel tmp = null;
		try {
			
			tmp = this.service.getById(item.getId());

			if (action.equals("insert")) {
				item.setCreatedDate(new Date());
				item.setUpdatedDate(new Date());
				item.setCreatedBy(new String ("admin"));
				item.setUpdatedBy(new String ("admin"));
				this.service.insert(item);
			} else if (action.equals("update")){
				item.setCreatedDate(new Date());
				item.setUpdatedDate(new Date());
				item.setCreatedBy(new String ("admin"));
				item.setUpdatedBy(new String ("admin"));
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

		return "/master/company/save";
	}
	

}
