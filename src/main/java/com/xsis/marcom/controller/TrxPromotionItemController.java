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

import com.xsis.marcom.model.TrxPromotionItemModel;
import com.xsis.marcom.service.TrxPromotionItemService;

@Controller
public class TrxPromotionItemController {
	
private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private TrxPromotionItemService service;
	
	@RequestMapping(value="/trx/promotion-item")
	public ModelAndView promotionIndex(Model model) {
		return new ModelAndView("/trx/promotion-item");
	}
	
	@RequestMapping(value = "/trx/promotion-item/list", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		Collection<TrxPromotionItemModel> result = null;
		try {
			result = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/trx/promotion-item/list");
	}

	@RequestMapping(value = "/trx/promotion-item/search", method = RequestMethod.GET)
	public ModelAndView search(Model model, HttpServletRequest request) {
		String keySearch = request.getParameter("key");
		Collection<TrxPromotionItemModel> result = null;
		try {
			result = this.service.search(keySearch);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("list", result);

		return new ModelAndView("/trx/promotion-item/list");
	}

	@RequestMapping(value = "/trx/promotion-item/add", method = RequestMethod.GET)
	public ModelAndView add(Model model) {
		return new ModelAndView("/trx/promotion-item/add");
	}

	@RequestMapping(value = "/trx/promotion-item/edit")
	public ModelAndView edit(Model model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		TrxPromotionItemModel result = new TrxPromotionItemModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/trx/promotion-item/edit");
	}

	@RequestMapping(value = "/trx/promotion-item/delete")
	public ModelAndView delete(Model model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		TrxPromotionItemModel result = new TrxPromotionItemModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", result);

		return new ModelAndView("/trx/promotion-item/delete");
	}

	@RequestMapping(value = "/trx/promotion-item/save")
	public String save(Model model, @ModelAttribute TrxPromotionItemModel item, HttpServletRequest request) {
		String result = "";
		String action = request.getParameter("action");
		TrxPromotionItemModel tmp = null;
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

		return "/trx/promotion-item/save";
	}
	

}
