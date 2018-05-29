package com.xsis.marcom.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.marcom.dao.MstEmployeeDao;
import com.xsis.marcom.model.MstEmployeeModel;

@Repository
public class MstEmployeeDaoImpl implements MstEmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<MstEmployeeModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<MstEmployeeModel> result = session.createQuery("from MstEmployeeModel").list();
		return result;
	}

	@Override
	public List<MstEmployeeModel> search(String keySearch) throws Exception {		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MstEmployeeModel.class);
		criteria.add(Restrictions.like("name", "%" + keySearch + "%"));
		List<MstEmployeeModel> result = criteria.list();
		return result;
	}

	@Override
	public MstEmployeeModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		MstEmployeeModel result = session.get(MstEmployeeModel.class, id);
		return result;
	}

	@Override
	public void insert(MstEmployeeModel model) throws Exception {
		sessionFactory.getCurrentSession().save(model);
	}

	@Override
	public void update(MstEmployeeModel model) throws Exception {
		sessionFactory.getCurrentSession().update(model);
	}

	@Override
	public void delete(MstEmployeeModel model) throws Exception {
		sessionFactory.getCurrentSession().delete(model);
	}


}
