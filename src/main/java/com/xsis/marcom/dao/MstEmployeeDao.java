package com.xsis.marcom.dao;

import java.util.List;


import com.xsis.marcom.model.MstEmployeeModel;

public interface MstEmployeeDao {
	public List<MstEmployeeModel> get() throws Exception;
	public List<MstEmployeeModel> search(String keySearch) throws Exception;
	public MstEmployeeModel getById(int id) throws Exception;
	public void insert(MstEmployeeModel model) throws Exception;
	public void update(MstEmployeeModel model) throws Exception;
	public void delete(MstEmployeeModel model) throws Exception;

}
