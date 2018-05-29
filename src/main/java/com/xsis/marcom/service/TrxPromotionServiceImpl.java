package com.xsis.marcom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.marcom.dao.TrxPromotionDao;
import com.xsis.marcom.model.TrxPromotionModel;

@Service
@Transactional
public class TrxPromotionServiceImpl implements TrxPromotionService {
	
	@Autowired private TrxPromotionDao dao;

	@Override
	public List<TrxPromotionModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public List<TrxPromotionModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public TrxPromotionModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void insert(TrxPromotionModel model) throws Exception {
		this.dao.insert(model);
		
	}

	@Override
	public void update(TrxPromotionModel model) throws Exception {
		this.dao.update(model);
		
	}

	@Override
	public void delete(TrxPromotionModel model) throws Exception {
		this.dao.delete(model);
		
	}

}
