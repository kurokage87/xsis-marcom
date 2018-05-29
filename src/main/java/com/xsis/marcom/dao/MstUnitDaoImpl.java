package com.xsis.marcom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.marcom.dao.MstUnitDao;
import com.xsis.marcom.model.MstUnitModel;

@Repository
public class MstUnitDaoImpl implements MstUnitDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<MstUnitModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<MstUnitModel> result = session.createQuery("from MstUnitModel").list();
		return result;
	}

	@Override
	public List<MstUnitModel> search(String keySearch) throws Exception {		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MstUnitModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<MstUnitModel> result = criteria.list();
		return result;
	}

	@Override
	public MstUnitModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		MstUnitModel result = session.get(MstUnitModel.class, id);
		return result;
	}

	@Override
	public void insert(MstUnitModel model) throws Exception {
		sessionFactory.getCurrentSession().save(model);
	}

	@Override
	public void update(MstUnitModel model) throws Exception {
		sessionFactory.getCurrentSession().update(model);
	}

	@Override
	public void delete(MstUnitModel model) throws Exception {
		sessionFactory.getCurrentSession().delete(model);
	}


}
