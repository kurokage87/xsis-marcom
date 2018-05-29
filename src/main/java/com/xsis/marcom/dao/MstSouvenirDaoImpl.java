package com.xsis.marcom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.marcom.common.StringConverter;
import com.xsis.marcom.model.MstSouvenirModel;

@Repository
public class MstSouvenirDaoImpl implements MstSouvenirDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String getCode() throws Exception {
		// TODO Auto-generated method stub
		String result = "";
		Session session = sessionFactory.getCurrentSession();
		List list = session.createQuery("select max(s.code) from MstSouvenirModel s where s.code like 'SV0001'").list();
		result = list.get(0).toString();
		if(result.equals("")) {
			result = "SV0001";
		}else {
			String[] arrCode = result.split("V");
			int newCode = Integer.parseInt(arrCode[1]) + 1;
			result ="SV"+ StringConverter.intToString(newCode, 4);
			//result = "SV"+ newCode;
		}
		return result;
	}
	
	@Override
	public List<MstSouvenirModel> get() throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<MstSouvenirModel> result = session.createQuery("from MstSouvenirModel where is_delete = 0 order by code desc").list();
		return result;
	}

	@Override
	public List<MstSouvenirModel> search(String keySearch,String keyName,String createdDate,String keyCreatedBy) throws Exception {
		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		Criteria criteria = session.createCriteria(MstSouvenirModel.class);
//		criteria.add(Restrictions.like("name", "%"+keySearch+"%"));
//		List<MstSouvenirModel> result = criteria.list();
		
		Session session = sessionFactory.getCurrentSession();
		List<MstSouvenirModel> result = session.createQuery("from MstSouvenirModel where code ='"+keySearch
				+"'or name='"+keyName+"' or TRUNC(createdDate = TO_DATE('"
				+createdDate+"', 'yyyy-MM-dd') or createdBy='"
				+keyCreatedBy+"'").list();
		return result;
	}

	@Override
	public MstSouvenirModel getById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		MstSouvenirModel result = session.get(MstSouvenirModel.class, id);
		return result;
	}

	@Override
	public void tambah(MstSouvenirModel model) throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(model);
	}

	@Override
	public void ubah(MstSouvenirModel model) throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(model);
	}

	@Override
	public void hapus(MstSouvenirModel model) throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(model);
	}

	

}
