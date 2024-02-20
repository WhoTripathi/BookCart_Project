package Servalate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Entity.Notes;
import helperClases.FactoryProvider;

/**
 * Servlet implementation class DeletNote
 */
public class DeletNote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletNote() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			int id = Integer.parseInt(request.getParameter("note_id").trim());
			Session session = FactoryProvider.getFactory().openSession();
			Transaction t = session.beginTransaction();
			Notes notes = session.load(Notes.class, id);
			session.delete(notes);
			t.commit();
			session.close();
			response.sendRedirect("allNotes.jsp");

		} catch (Exception e) {

		}

	}

}
