package com.richie.DAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.richie.entity.EntityClass;

@Repository
public class EntityDAOImpl implements EntityDAO {

	@Autowired
	private SessionFactory sessionfactory;

	private Session openSession() {

		return sessionfactory.getCurrentSession();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EntityClass> listUser() {

		return openSession().createQuery("from EntityClass").list();
	}

	@Override
	public void saveUser(EntityClass user) {

		openSession().saveOrUpdate(user);

	}
	
	@Override
	public EntityClass UpdateUser(EntityClass user) {
		
		openSession().update(user);
		
		return user;
	}

	@Override
	public EntityClass getUserById(int id) {

		EntityClass user = (EntityClass) openSession().get(EntityClass.class, id);

		return user;
	}

	@Override
	public void deleteUser(int id) {

		EntityClass user = openSession().get(EntityClass.class, id);
		openSession().delete(user);

	}

}
