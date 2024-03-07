package com.bookcart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bookcart.database.ConnectDB;
import com.bookcart.database.JDBConnection;
import com.bookcart.entity.RegisteredUser;

public class UserDAOImp implements UserDAO {

	public boolean registerUser(RegisteredUser rUser) {

		boolean f = false;
		try {
			SessionFactory sf = ConnectDB.buildConnection();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();

			session.save(rUser);

			transaction.commit();

			session.close();
			f = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return f;
	}

	public ArrayList<RegisteredUser> fetchAllUser() {

		ArrayList<RegisteredUser> list = new ArrayList<RegisteredUser>();
		try {
			Connection connection = JDBConnection.getConnect();
			String fetchUser = "Select * from RegisteredUser";
			PreparedStatement preparedStatement = connection.prepareStatement(fetchUser);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				RegisteredUser registeredUser = new RegisteredUser();
				registeredUser.setId(rs.getInt(1));
				registeredUser.setPinCode(rs.getString(2));
				registeredUser.setName(rs.getString(3));
				registeredUser.setPhoneNumber(rs.getString(5));
				registeredUser.setUserEmail(rs.getString(6));
				registeredUser.setAddress(rs.getString(7));

				list.add(registeredUser);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean deleteUserById(int i) {
		boolean f = false;
		Connection connection = JDBConnection.getConnect();
		try {
			String deleteQuery = "delete from registeredUser where Id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, i);
			int row = preparedStatement.executeUpdate();
			if (row == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public RegisteredUser fetchUserById(int userId) {
		RegisteredUser rUser = new RegisteredUser();
		try {
			Connection connection = JDBConnection.getConnect();
			String fetchUser = "Select * from registeredUser where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(fetchUser);
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				rUser.setId(rs.getInt(1));
				rUser.setAddress(rs.getString(7));
				rUser.setPinCode(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rUser;
	}

}
