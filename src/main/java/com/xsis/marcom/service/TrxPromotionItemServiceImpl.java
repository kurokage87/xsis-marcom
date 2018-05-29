package com.xsis.marcom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.marcom.dao.TrxPromotionItemDao;
import com.xsis.marcom.model.TrxPromotionItemModel;

@Service
@Transactional
public class TrxPromotionItemServiceImpl implements TrxPromotionItemService {
	
	@Autowired private TrxPromotionItemDao dao;

	@Override
	public List<TrxPromotionItemModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public List<TrxPromotionItemModel> search(String keySearch) throws Exception {
		return this.dao.search(keySearch);
	}

	@Override
	public TrxPromotionItemModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void insert(TrxPromotionItemModel model) throws Exception {
		this.dao.insert(model);
		
	}

	@Override
	public void update(TrxPromotionItemModel model) throws Exception {
		this.dao.update(model);
		
	}

	@Override
	public void delete(TrxPromotionItemModel model) throws Exception {
		this.dao.delete(model);
		
	}

}
