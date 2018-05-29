package com.xsis.marcom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.marcom.dao.MstCompnyDao;
import com.xsis.marcom.model.MstCompanyModel;
import com.xsis.marcom.service.MstCompanyService;

@Service
@Transactional
public class MstCompanyServiceImpl implements MstCompanyService {
	
	@Autowired private MstCompnyDao dao;

	@Override
	public List<MstCompanyModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public List<MstCompanyModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public MstCompanyModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void insert(MstCompanyModel model) throws Exception {
		this.dao.insert(model);
		
	}

	@Override
	public void update(MstCompanyModel model) throws Exception {
		this.dao.update(model);
		
	}

	@Override
	public void delete(MstCompanyModel model) throws Exception {
		this.dao.delete(model);
		
	}
	

}
