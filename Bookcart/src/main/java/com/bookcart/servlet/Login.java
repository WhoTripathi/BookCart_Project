package com.bookcart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookcart.DAO.LoginDAOImpl;
import com.bookcart.entity.RegisteredUser;

@WebServlet("/login")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String email=req.getParameter("email");
			String pass=req.getParameter("password");
			System.out.println(email+pass);
			if(email.equals("bhupendratripathi.999@gmail.com") && pass.equals("Test@143"))
			{
				HttpSession session=req.getSession();
				session.setAttribute("admin", email);
				resp.sendRedirect("Admin/Home.jsp");
			}
			else {
				HttpSession session=req.getSession();
				RegisteredUser rs=new RegisteredUser();
				LoginDAOImpl loginPage=new LoginDAOImpl();
				rs=loginPage.checkCredentials(email, pass);
				if(rs==null)
				{
					session.setAttribute("invalidPass", "Login id or Password is invalid...!");
					resp.sendRedirect("Login.jsp");
				}
				else {
					session.setAttribute("user", rs);
					System.out.println(rs.getName());
					resp.sendRedirect("index.jsp");
				}
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
