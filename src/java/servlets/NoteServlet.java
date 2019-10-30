package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;
import services.NoteService;

/**
 *
 * @author 652343
 */
public class NoteServlet extends HttpServlet
  {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
      {
        NoteService ns = new NoteService();
        List<Note> notes = ns.getAll();
        request.setAttribute("notes", notes);
        
       getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
      }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
      {
        
      }


  }
