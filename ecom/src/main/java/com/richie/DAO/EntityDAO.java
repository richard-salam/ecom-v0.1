package com.richie.DAO;


import java.util.List;

import com.richie.entity.EntityClass;

public interface EntityDAO {

	public void saveUser(EntityClass user);
	
	public List<EntityClass> listUser();
	
	public void deleteUser(int id);
	
	public EntityClass UpdateUser(EntityClass user);

	public EntityClass getUserById(int id);


}
