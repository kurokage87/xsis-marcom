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

import com.xsis.marcom.model.TrxPromotionModel;
import com.xsis.marcom.service.TrxPromotionService;

@Controller
public class TrxPromotionController {
	
private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private TrxPromotionService service;
	
	@RequestMapping(value="/trx/promotion")
	public ModelAndView promotionIndex(Model model) {
		return new ModelAndView("/trx/promotion");
	}
	
	@RequestMapping(value = "/trx/promotion/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		Collection<TrxPromotionModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/trx/promotion/list");
	}

	@RequestMapping(value = "/trx/promotion/search", method = RequestMethod.GET)
	public ModelAndView search(Model model, HttpServletRequest request) {
		String keySearch = request.getParameter("key");
		Collection<TrxPromotionModel> result = null;
		try {
			result = this.service.search(keySearch);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/trx/promotion/list");
	}

	@RequestMapping(value = "/trx/promotion/add", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		return new ModelAndView("/trx/promotion/add");
	}

	@RequestMapping(value = "/trx/promotion/edit")
	public ModelAndView edit(Model model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		TrxPromotionModel result = new TrxPromotionModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/trx/promotion/edit");
	}

	@RequestMapping(value = "/trx/promotion/delete")
	public ModelAndView delete(Model model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		TrxPromotionModel result = new TrxPromotionModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/trx/promotion/delete");
	}

	@RequestMapping(value = "/trx/promotion/save")
	public String save(Model model, @ModelAttribute TrxPromotionModel item, HttpServletRequest request) {
		String result = "";
		String action = request.getParameter("action");
		TrxPromotionModel tmp = null;
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

		return "/trx/promotion/save";
	}
	

}
