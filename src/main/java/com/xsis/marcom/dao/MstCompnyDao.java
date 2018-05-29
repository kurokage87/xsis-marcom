package com.xsis.marcom.dao;

import java.util.List;

import com.xsis.marcom.model.MstCompanyModel;

public interface MstCompnyDao {
	public List<MstCompanyModel> get() throws Exception;
	public List<MstCompanyModel> search(String keySearch) throws Exception;
	public MstCompanyModel getById(int id) throws Exception;
	public void insert(MstCompanyModel model) throws Exception;
	public void update(MstCompanyModel model) throws Exception;
	public void delete(MstCompanyModel model) throws Exception;

}
