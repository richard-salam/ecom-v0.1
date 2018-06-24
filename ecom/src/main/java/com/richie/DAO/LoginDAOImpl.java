package com.richie.DAO;

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

}
