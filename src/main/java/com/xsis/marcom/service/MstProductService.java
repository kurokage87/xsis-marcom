package com.xsis.marcom.service;

import java.util.List;

import com.xsis.marcom.model.MstProductModel;

public interface MstProductService {
	public List<MstProductModel> get() throws Exception;
	public List<MstProductModel> search(String keySearch) throws Exception;
	public MstProductModel getById(int id) throws Exception;
	public void insert(MstProductModel model) throws Exception;
	public void update(MstProductModel model) throws Exception;
	public void delete(MstProductModel model) throws Exception;

}
