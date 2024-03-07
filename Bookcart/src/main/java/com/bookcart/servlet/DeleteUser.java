package com.bookcart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookcart.DAO.UserDAOImp;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int Id=Integer.parseInt(req.getParameter("id"));
		UserDAOImp userDAOImp=new UserDAOImp();
		if(userDAOImp.deleteUserById(Id))
		{
			resp.sendRedirect("Admin/registeredUsers.jsp");
		}
		
	}
	
	

}
