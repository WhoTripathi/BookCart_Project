package Servalate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Entity.Notes;
import helperClases.FactoryProvider;

public class SaveNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveNotes() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			HttpSession getSession=request.getSession(false);
			String userEmail=(String)getSession.getAttribute("Useremail");
			Notes note = new Notes(title, content, new Date(),userEmail);
			SessionFactory sf=FactoryProvider.getFactory();
			Session session=sf.openSession();
			Transaction ts=session.beginTransaction();
			session.save(note);
			ts.commit();
			session.close();
			response.sendRedirect("allNotes.jsp");
		}

		catch (Exception E) {

		}
	}

}
