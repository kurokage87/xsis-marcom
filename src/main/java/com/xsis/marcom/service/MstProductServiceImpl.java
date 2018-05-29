package com.xsis.marcom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.marcom.dao.MstProductDao;
import com.xsis.marcom.model.MstProductModel;
import com.xsis.marcom.service.MstProductService;

@Service
@Transactional
public class MstProductServiceImpl implements MstProductService {
	
	@Autowired private MstProductDao dao;

	@Override
	public List<MstProductModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public List<MstProductModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public MstProductModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void insert(MstProductModel model) throws Exception {
		this.dao.insert(model);
		
	}

	@Override
	public void update(MstProductModel model) throws Exception {
		this.dao.update(model);
		
	}

	@Override
	public void delete(MstProductModel model) throws Exception {
		this.dao.delete(model);
		
	}
	

}
