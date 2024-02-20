package Servalate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import Entity.RegisteredUsers;
import helperClases.FactoryProvider;

/**
 * Servlet implementation class LoginAuth
 */
public class LoginAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAuth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email_id");
		String pass=request.getParameter("password");
		Session session=FactoryProvider.getFactory().openSession();
		RegisteredUsers user=null;
		user=(RegisteredUsers)session.get(RegisteredUsers.class, email);
		
		if(user==null||!(email.equals(user.getEmail()))||!(pass.equals(user.getPassword())))
		{
			response.sendRedirect("index.jsp");
		}
		else {
			HttpSession s=request.getSession(true);
			s.setAttribute("Useremail", user.getEmail());
			response.sendRedirect("allNotes.jsp");
		}

	}

}
