package com.richie.service;


import java.util.List;

import com.richie.entity.EntityClass;

public interface EntityService {

	public List<EntityClass> listUser();

	public void saveUser(EntityClass user);
	
	public EntityClass UpdateUser(EntityClass user);

	public EntityClass getUserById(int id);

	public void deleteUser(int id);

}
