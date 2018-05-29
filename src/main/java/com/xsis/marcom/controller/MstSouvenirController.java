package com.xsis.marcom.controller;

import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.xsis.marcom.model.MstSouvenirModel;
import com.xsis.marcom.service.MstSouvenirService;

@Controller
public class MstSouvenirController {
	
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private MstSouvenirService service;
	
	//membuat index
	@RequestMapping(value="/master/souvenir")
	public ModelAndView MstSouvenirIndex(Model model) {
		return new ModelAndView("/master/souvenir");
	}
	
	//membuat list
	@RequestMapping(value="/master/souvenir/list", method=RequestMethod.GET)
	public ModelAndView list(Model model) {
		Collection<MstSouvenirModel> result = null;
		try {
			result = this.service.get(); //mengambil data dari database
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage(), e); //memunculkan error console
		}
		model.addAttribute("list", result); //menampilkan data pada list
		return new ModelAndView("/master/souvenir/list");
	}
	
	//membuat list search
	@RequestMapping(value="/master/souvenir/search", method=RequestMethod.GET)
	public ModelAndView search(Model model, HttpServletRequest request) {
		String keySearch = request.getParameter("key"); //menentukan parameter pencarian
		Collection<MstSouvenirModel> result = null; // menampilkan hasil
		try {
			result = this.service.search(keySearch);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage(), e); //menampilkan error di console
		}
		model.addAttribute("list", result); //menampilkan semua atribute table
		return new ModelAndView("/master/souvenir/list");
	}
	
	//membuat tambah data
	@RequestMapping(value="/master/souvenir/tambah", method=RequestMethod.GET)
	public ModelAndView tambah(Model model) {
		String code = "SV0001";
		try {
			code = this.service.getCode();
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage(), e);
		}
		model.addAttribute("newCode",code);
		return new ModelAndView("/master/souvenir/add");
	}
	
	//membuat edit data
	@RequestMapping(value="/master/souvenir/ubah")
	public ModelAndView ubah(Model model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		MstSouvenirModel result = new MstSouvenirModel();
		try {
			result = this.service.getById(id); // mengambil data berdasarkan id
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage(), e); //error console
		}
		model.addAttribute("item", result); //indikator pada form
		return new ModelAndView("/master/souvenir/edit");
	}
	
	//membut hapus data
	@RequestMapping(value="/master/souvenir/hapus")
	public ModelAndView hapus(Model model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		MstSouvenirModel result = new MstSouvenirModel();
		try {
			result = this.service.getById(id);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage(),e);
		}
		model.addAttribute("item", result);
		return new ModelAndView("/master/souvenir/hapus");
	}
	
	//mambuat konfiguari save json dengan ajax
	@RequestMapping(value="/master/souvenir/simpan")
	public String simpan(Model model, @ModelAttribute MstSouvenirModel item, HttpServletRequest request) {
		String result = "";
		String action = request.getParameter("action");
		MstSouvenirModel tmp = null;
		try {
			
			tmp = this.service.getById(item.getId());
			//kondisi simpan
			if (action.equals("tambah")) {
				item.setIsDelete(new Integer(0));
				item.setCreatedBy(new String("admin"));
				item.setCreatedDate(new Date());
				this.service.tambah(item);
			}else if (action.equals("ubah")) {
				item.setUpdateBy(new String("dummy"));
				item.setUpdateDate(new Date());
				item.setCreatedBy(new String(tmp.getCreatedBy()));
				item.setCreatedDate(tmp.getCreatedDate());
				item.setIsDelete(new Integer(tmp.getIsDelete()));
				this.service.ubah(item);
			}else if (action.equals("hapus")) {
				tmp.setCode(new String(tmp.getCode()));
				tmp.setName(new String(tmp.getName()));
				tmp.setIsDelete(1);
				this.service.ubah(tmp);
			}
			
			result = "success";
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage(), e);
			result = "failed";
		}
		model.addAttribute("message", result);
		return "/master/souvenir/simpan";
	}
}
