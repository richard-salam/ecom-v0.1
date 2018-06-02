package com.richie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.richie.DAO.EntityDAO;
import com.richie.entity.EntityClass;

@Service
@Transactional
public class EntityServiceImpl implements EntityService {

	@Autowired
	private EntityDAO entitydao;

	@Override
	@Transactional
	public List<EntityClass> listUser() {

		return entitydao.listUser();

	}

	@Override
	@Transactional
	public void saveUser(EntityClass user) {

		entitydao.saveUser(user);

	}

	@Override
	public EntityClass UpdateUser(EntityClass user) {

		return entitydao.UpdateUser(user);
	}

	@Override
	public EntityClass getUserById(int id) {

		return entitydao.getUserById(id);

	}

	@Override
	@Transactional
	public void deleteUser(int id) {

		entitydao.deleteUser(id);

	}

}
