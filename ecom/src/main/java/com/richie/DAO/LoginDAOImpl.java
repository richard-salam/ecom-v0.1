package com.richie.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.richie.entity.LoginEntity;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {

		return sessionFactory.getCurrentSession();

	}

	@Override
	public void registerUser(LoginEntity user) {
		
		openSession().saveOrUpdate(user);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoginEntity> listUser() {
		
		return openSession().createQuery("from LoginEntity").list();
		
	}

}
