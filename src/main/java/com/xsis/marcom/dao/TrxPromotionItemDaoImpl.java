package com.xsis.marcom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.marcom.model.TrxPromotionItemModel;


@Repository
public class TrxPromotionItemDaoImpl implements TrxPromotionItemDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<TrxPromotionItemModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<TrxPromotionItemModel> result = session.createQuery("from TrxPromotionItemModel").list();
		return result;
	}

	@Override
	public List<TrxPromotionItemModel> search(String keySearch) throws Exception {		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TrxPromotionItemModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<TrxPromotionItemModel> result = criteria.list();
		return result;
	}

	@Override
	public TrxPromotionItemModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		TrxPromotionItemModel result = session.get(TrxPromotionItemModel.class, id);
		return result;
	}

	@Override
	public void insert(TrxPromotionItemModel model) throws Exception {
		sessionFactory.getCurrentSession().save(model);
	}

	@Override
	public void update(TrxPromotionItemModel model) throws Exception {
		sessionFactory.getCurrentSession().update(model);
	}

	@Override
	public void delete(TrxPromotionItemModel model) throws Exception {
		sessionFactory.getCurrentSession().delete(model);
	}

}
