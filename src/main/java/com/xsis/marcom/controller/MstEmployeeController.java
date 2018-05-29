package com.xsis.marcom.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;

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
import com.xsis.marcom.model.MstEmployeeModel;
import com.xsis.marcom.service.MstCompanyService;
import com.xsis.marcom.service.MstEmployeeService;

@Controller
public class MstEmployeeController {
	
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private MstEmployeeService service;
	
	@Autowired
	private MstCompanyService companyService;
	
	@RequestMapping(value="/master/employee")
	public ModelAndView employeeIndex(Model model) {
		return new ModelAndView("/master/employee");
	}
	
	@RequestMapping(value = "/master/employee/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		Collection<MstEmployeeModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/employee/list");
	}

	@RequestMapping(value = "/master/employee/search", method = RequestMethod.GET)
	public ModelAndView search(Model model, HttpServletRequest request) {
		String keySearch = request.getParameter("key");
		Collection<MstEmployeeModel> result = null;
		try {
			result = this.service.search(keySearch);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/master/employee/list");
	}

	@RequestMapping(value = "/master/employee/add", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		List<MstCompanyModel> companylist = null;
		try {
			companylist = companyService.get();
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("companylist", companylist);
		
		return new ModelAndView("/master/employee/add");
	}

	@RequestMapping(value = "/master/employee/edit")
	public ModelAndView edit(Model model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		MstEmployeeModel result = new MstEmployeeModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/master/employee/edit");
	}

	@RequestMapping(value = "/master/employee/delete")
	public ModelAndView delete(Model model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		MstEmployeeModel result = new MstEmployeeModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/master/employee/delete");
	}

	@RequestMapping(value = "/master/employee/save")
	public String save(Model model, @ModelAttribute MstEmployeeModel item, HttpServletRequest request) {
		String result = "";
		String action = request.getParameter("action");
		MstEmployeeModel tmp = null;
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

		return "/master/employee/save";
	}
	

}
