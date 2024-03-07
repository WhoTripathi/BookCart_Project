package com.bookcart.DAO;

import com.bookcart.entity.RegisteredUser;

public interface LoginDAO {
	public RegisteredUser checkCredentials(String email,String password);

}
