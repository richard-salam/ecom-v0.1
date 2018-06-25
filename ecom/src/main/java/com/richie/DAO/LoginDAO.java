package com.richie.DAO;

import java.util.List;

import com.richie.entity.LoginEntity;

public interface LoginDAO {
	
	public void registerUser(LoginEntity user);

	public List<LoginEntity> listUser();

}
