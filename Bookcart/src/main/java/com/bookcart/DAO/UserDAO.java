package com.bookcart.DAO;

import java.util.ArrayList;

import com.bookcart.entity.RegisteredUser;

public interface UserDAO {
	public boolean registerUser(RegisteredUser rUser);
	public ArrayList<RegisteredUser> fetchAllUser();
	public boolean deleteUserById(int i);

}
