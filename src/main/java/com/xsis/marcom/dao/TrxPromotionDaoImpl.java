package com.xsis.marcom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.marcom.model.TrxPromotionModel;

@Repository
public class TrxPromotionDaoImpl implements TrxPromotionDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<TrxPromotionModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<TrxPromotionModel> result = session.createQuery("from TrxPromotionModel").list();
		return result;
	}

	@Override
	public List<TrxPromotionModel> search(String keySearch) throws Exception {		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TrxPromotionModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<TrxPromotionModel> result = criteria.list();
		return result;
	}

	@Override
	public TrxPromotionModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		TrxPromotionModel result = session.get(TrxPromotionModel.class, id);
		return result;
	}

	@Override
	public void insert(TrxPromotionModel model) throws Exception {
		sessionFactory.getCurrentSession().save(model);
	}

	@Override
	public void update(TrxPromotionModel model) throws Exception {
		sessionFactory.getCurrentSession().update(model);
	}

	@Override
	public void delete(TrxPromotionModel model) throws Exception {
		sessionFactory.getCurrentSession().delete(model);
	}

}
