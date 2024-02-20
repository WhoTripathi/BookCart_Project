package Servalate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Entity.RegisteredUsers;
import helperClases.FactoryProvider;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email_id");
		String password = request.getParameter("password");

//		HttpSession session=request.getSession(true);
//		if(session.getValue("useremail")==null)
		RegisteredUsers user = new RegisteredUsers();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		Session session = FactoryProvider.getFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		
		response.sendRedirect("allNotes.jsp");

	}

}
