package com.xsis.marcom.service;

import java.util.List;

import com.xsis.marcom.model.TrxPromotionModel;

public interface TrxPromotionService {
	public List<TrxPromotionModel> get() throws Exception;
	public List<TrxPromotionModel> search(String keySearch) throws Exception;
	public TrxPromotionModel getById(int id) throws Exception;
	public void insert(TrxPromotionModel model) throws Exception;
	public void update(TrxPromotionModel model) throws Exception;
	public void delete(TrxPromotionModel model) throws Exception;

}
