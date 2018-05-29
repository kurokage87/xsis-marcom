package com.xsis.marcom.service;

import java.util.List;

import com.xsis.marcom.model.MstSouvenirModel;


public interface MstSouvenirService {
	public String getCode() throws Exception;
	public List<MstSouvenirModel> get() throws Exception;
	public List<MstSouvenirModel> search(String keySearch,String keyName,String createdDate,String keyCreatedBy) throws Exception;
	public MstSouvenirModel getById(Integer id) throws Exception;
	public void tambah(MstSouvenirModel model) throws Exception;
	public void ubah(MstSouvenirModel model) throws Exception;
	public void hapus(MstSouvenirModel model) throws Exception;
}
