package com.xsis.marcom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.marcom.dao.TrxPromotionItemFileDao;
import com.xsis.marcom.model.TrxPromotionItemFileModel;

@Service
@Transactional
public class TrxPromotionItemFileServiceImpl implements TrxPromotionItemFileService {
	
	@Autowired private TrxPromotionItemFileDao dao;

	@Override
	public List<TrxPromotionItemFileModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public List<TrxPromotionItemFileModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public TrxPromotionItemFileModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void insert(TrxPromotionItemFileModel model) throws Exception {
		this.dao.insert(model);
		
	}

	@Override
	public void update(TrxPromotionItemFileModel model) throws Exception {
		this.dao.update(model);
		
	}

	@Override
	public void delete(TrxPromotionItemFileModel model) throws Exception {
		this.dao.delete(model);
		
	}

}
