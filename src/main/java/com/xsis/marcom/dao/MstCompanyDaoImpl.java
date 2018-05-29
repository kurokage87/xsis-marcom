package com.xsis.marcom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.marcom.dao.MstCompnyDao;
import com.xsis.marcom.model.MstCompanyModel;

@Repository
public class MstCompanyDaoImpl implements MstCompnyDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<MstCompanyModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<MstCompanyModel> result = session.createQuery("from MstCompanyModel").list();
		return result;
	}

	@Override
	public List<MstCompanyModel> search(String keySearch) throws Exception {		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MstCompanyModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<MstCompanyModel> result = criteria.list();
		return result;
	}

	@Override
	public MstCompanyModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		MstCompanyModel result = session.get(MstCompanyModel.class, id);
		return result;
	}

	@Override
	public void insert(MstCompanyModel model) throws Exception {
		sessionFactory.getCurrentSession().save(model);
	}

	@Override
	public void update(MstCompanyModel model) throws Exception {
		sessionFactory.getCurrentSession().update(model);
	}

	@Override
	public void delete(MstCompanyModel model) throws Exception {
		sessionFactory.getCurrentSession().delete(model);
	}


}
