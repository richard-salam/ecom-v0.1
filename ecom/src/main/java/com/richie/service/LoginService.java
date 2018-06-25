package com.richie.service;

import java.util.List;

import com.richie.entity.LoginEntity;

public interface LoginService {
	
	public void registerUser(LoginEntity user);

	public List<LoginEntity> listUser();
	
}
