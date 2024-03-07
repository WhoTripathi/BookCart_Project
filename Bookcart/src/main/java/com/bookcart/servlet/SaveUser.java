package com.bookcart.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookcart.DAO.UserDAOImp;
import com.bookcart.entity.RegisteredUser;

@WebServlet("/register")
public class SaveUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String phoneNumber=req.getParameter("phone");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		String pincode=req.getParameter("pincode");
		RegisteredUser rUser=new RegisteredUser();
		
		rUser.setName(name);
		rUser.setPhoneNumber(phoneNumber);
		rUser.setUserEmail(email);
		rUser.setPassword(password);
		rUser.setAddress(address);
		rUser.setPinCode(pincode);
		
		Random random=new Random();
		int id= random.nextInt(10000);
		rUser.setId(id);
		
		HttpSession session=req.getSession();
		
		UserDAOImp saveUser=new UserDAOImp();
		if(saveUser.registerUser(rUser))
		{
			//System.out.println("Record Inserted SuccessFully...!");
			session.setAttribute("success", "User registered SuccessFully...!");
			resp.sendRedirect("Register.jsp");
		}
		else {
			//System.out.println("Somthing went wrond....!");
			session.setAttribute("failed", "Somthing went wrond....!");
			resp.sendRedirect("Register.jsp");
		}
	}

}
