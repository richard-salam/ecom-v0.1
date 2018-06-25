package com.richie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.richie.DAO.LoginDAO;
import com.richie.entity.LoginEntity;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO logindao;

	@Override
	public void registerUser(LoginEntity user) {
		logindao.registerUser(user);
	}

	@Override
	public List<LoginEntity> listUser() {

		return logindao.listUser();
		
	}

}
