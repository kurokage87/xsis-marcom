package com.xsis.marcom.service;

import java.util.List;

import com.xsis.marcom.model.TrxPromotionItemFileModel;

public interface TrxPromotionItemFileService {
	public List<TrxPromotionItemFileModel> get() throws Exception;
	public List<TrxPromotionItemFileModel> search(String keySearch) throws Exception;
	public TrxPromotionItemFileModel getById(int id) throws Exception;
	public void insert(TrxPromotionItemFileModel model) throws Exception;
	public void update(TrxPromotionItemFileModel model) throws Exception;
	public void delete(TrxPromotionItemFileModel model) throws Exception;

}
