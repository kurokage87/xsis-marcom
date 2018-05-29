package com.xsis.marcom.service;

import java.util.List;

import com.xsis.marcom.model.MstUnitModel;

public interface MstUnitService {
	public List<MstUnitModel> get() throws Exception;
	public List<MstUnitModel> search(String keySearch) throws Exception;
	public MstUnitModel getById(int id) throws Exception;
	public void insert(MstUnitModel model) throws Exception;
	public void update(MstUnitModel model) throws Exception;
	public void delete(MstUnitModel model) throws Exception;

}
