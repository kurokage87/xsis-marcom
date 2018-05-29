package com.xsis.marcom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.marcom.dao.MstEmployeeDao;
import com.xsis.marcom.model.MstEmployeeModel;
import com.xsis.marcom.service.MstEmployeeService;

@Service
@Transactional
public class MstEmployeeServiceImpl implements MstEmployeeService {
	
	@Autowired private MstEmployeeDao dao;

	@Override
	public List<MstEmployeeModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public List<MstEmployeeModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public MstEmployeeModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void insert(MstEmployeeModel model) throws Exception {
		this.dao.insert(model);
		
	}

	@Override
	public void update(MstEmployeeModel model) throws Exception {
		this.dao.update(model);
		
	}

	@Override
	public void delete(MstEmployeeModel model) throws Exception {
		this.dao.delete(model);
		
	}
	

}
