package Servalate;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Entity.Notes;
import helperClases.FactoryProvider;

/**
 * Servlet implementation class UpdateNotes
 */
public class UpdateNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNotes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("note_id").trim());
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		HttpSession value=request.getSession(false);
		String email=(String)value.getAttribute("Useremail");
		
		Session session=FactoryProvider.getFactory().openSession();
		Transaction tx=session.beginTransaction();
		
		Notes notes=(Notes)session.load(Notes.class, id);
		
		
		notes.setNoteId(notes.getNoteId());
		notes.setNoteTitle(title);
		notes.setNoteInstruction(content);
		notes.setNoteDate(new Date());
		notes.setUserEmail(email);
		session.update(notes);
		
		tx.commit();
		session.close();
		response.sendRedirect("allNotes.jsp");
		
	}

}
