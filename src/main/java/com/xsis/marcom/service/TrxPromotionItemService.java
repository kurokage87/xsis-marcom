package com.xsis.marcom.service;

import java.util.List;

import com.xsis.marcom.model.TrxPromotionItemModel;

public interface TrxPromotionItemService {
	public List<TrxPromotionItemModel> get() throws Exception;
	public List<TrxPromotionItemModel> search(String keySearch) throws Exception;
	public TrxPromotionItemModel getById(int id) throws Exception;
	public void insert(TrxPromotionItemModel model) throws Exception;
	public void update(TrxPromotionItemModel model) throws Exception;
	public void delete(TrxPromotionItemModel model) throws Exception;

}
