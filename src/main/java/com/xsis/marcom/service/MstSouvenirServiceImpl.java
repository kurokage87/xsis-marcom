package com.xsis.marcom.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.stereotype.Service;

import com.xsis.marcom.dao.MstSouvenirDao;
import com.xsis.marcom.model.MstSouvenirModel;

@Service
@Transactional
public class MstSouvenirServiceImpl implements MstSouvenirService {

	@Autowired
	private MstSouvenirDao dao;
	
	@Override
	public String getCode() throws Exception {
		// TODO Auto-generated method stub
		return this.dao.getCode();
	}
	
	@Override
	public List<MstSouvenirModel> get() throws Exception {
		// TODO Auto-generated method stub
		return this.dao.get();
	}

	@Override
	public List<MstSouvenirModel> search(String keySearch,String keyName,String createdDate,String keyCreatedBy) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.search(keySearch, keyName, createdDate, keyCreatedBy);
	}

	@Override
	public MstSouvenirModel getById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.getById(id);
	}

	@Override
	public void tambah(MstSouvenirModel model) throws Exception {
		// TODO Auto-generated method stub
		this.dao.tambah(model);
	}

	@Override
	public void ubah(MstSouvenirModel model) throws Exception {
		// TODO Auto-generated method stub
		this.dao.ubah(model);
	}

	@Override
	public void hapus(MstSouvenirModel model) throws Exception {
		// TODO Auto-generated method stub
		this.dao.hapus(model);
	}

}
