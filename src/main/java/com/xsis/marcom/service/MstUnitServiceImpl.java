package com.xsis.marcom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.marcom.dao.MstUnitDao;
import com.xsis.marcom.model.MstUnitModel;
import com.xsis.marcom.service.MstUnitService;

@Service
@Transactional
public class MstUnitServiceImpl implements MstUnitService {
	
	@Autowired private MstUnitDao dao;

	@Override
	public List<MstUnitModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public List<MstUnitModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public MstUnitModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void insert(MstUnitModel model) throws Exception {
		this.dao.insert(model);
		
	}

	@Override
	public void update(MstUnitModel model) throws Exception {
		this.dao.update(model);
		
	}

	@Override
	public void delete(MstUnitModel model) throws Exception {
		this.dao.delete(model);
		
	}
	

}
