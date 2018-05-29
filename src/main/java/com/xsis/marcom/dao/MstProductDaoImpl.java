package com.xsis.marcom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.marcom.dao.MstProductDao;
import com.xsis.marcom.model.MstProductModel;

@Repository
public class MstProductDaoImpl implements MstProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<MstProductModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<MstProductModel> result = session.createQuery("from MstProductModel").list();
		return result;
	}

	@Override
	public List<MstProductModel> search(String keySearch) throws Exception {		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MstProductModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<MstProductModel> result = criteria.list();
		return result;
	}

	@Override
	public MstProductModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		MstProductModel result = session.get(MstProductModel.class, id);
		return result;
	}

	@Override
	public void insert(MstProductModel model) throws Exception {
		sessionFactory.getCurrentSession().save(model);
	}

	@Override
	public void update(MstProductModel model) throws Exception {
		sessionFactory.getCurrentSession().update(model);
	}

	@Override
	public void delete(MstProductModel model) throws Exception {
		sessionFactory.getCurrentSession().delete(model);
	}


}
