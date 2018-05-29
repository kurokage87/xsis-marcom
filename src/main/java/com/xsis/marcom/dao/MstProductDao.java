package com.xsis.marcom.dao;

import java.util.List;


import com.xsis.marcom.model.MstProductModel;

public interface MstProductDao {
	public List<MstProductModel> get() throws Exception;
	public List<MstProductModel> search(String keySearch) throws Exception;
	public MstProductModel getById(int id) throws Exception;
	public void insert(MstProductModel model) throws Exception;
	public void update(MstProductModel model) throws Exception;
	public void delete(MstProductModel model) throws Exception;

}
