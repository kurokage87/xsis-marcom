package com.xsis.marcom.dao;

import java.util.List;

import com.xsis.marcom.model.TrxPromotionModel;

public interface TrxPromotionDao {
	public List<TrxPromotionModel> get() throws Exception;
	public List<TrxPromotionModel> search(String keySearch) throws Exception;
	public TrxPromotionModel getById(int id) throws Exception;
	public void insert(TrxPromotionModel model) throws Exception;
	public void update(TrxPromotionModel model) throws Exception;
	public void delete(TrxPromotionModel model) throws Exception;

}
