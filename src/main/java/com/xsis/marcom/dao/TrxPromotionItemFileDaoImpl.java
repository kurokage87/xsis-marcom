package com.xsis.marcom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.marcom.model.TrxPromotionItemFileModel;


@Repository
public class TrxPromotionItemFileDaoImpl implements TrxPromotionItemFileDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<TrxPromotionItemFileModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<TrxPromotionItemFileModel> result = session.createQuery("from TrxPromotionItemFileModel").list();
		return result;
	}

	@Override
	public List<TrxPromotionItemFileModel> search(String keySearch) throws Exception {		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TrxPromotionItemFileModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<TrxPromotionItemFileModel> result = criteria.list();
		return result;
	}

	@Override
	public TrxPromotionItemFileModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		TrxPromotionItemFileModel result = session.get(TrxPromotionItemFileModel.class, id);
		return result;
	}

	@Override
	public void insert(TrxPromotionItemFileModel model) throws Exception {
		sessionFactory.getCurrentSession().save(model);
	}

	@Override
	public void update(TrxPromotionItemFileModel model) throws Exception {
		sessionFactory.getCurrentSession().update(model);
	}

	@Override
	public void delete(TrxPromotionItemFileModel model) throws Exception {
		sessionFactory.getCurrentSession().delete(model);
	}

}
