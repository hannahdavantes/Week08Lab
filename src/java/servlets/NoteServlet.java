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
        String action = (String) request.getParameter("action");
        if (action == null)
          {
            request.setAttribute("edit", false);

          }
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);

      }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
      {
        NoteService ns = new NoteService();
        String action = (String) request.getParameter("action");
        String title = (String) request.getParameter("inputTitle");
        String contents = (String) request.getParameter("inputContents");
        
        if(action.equals("add"))
          {
            request.setAttribute("edit", false);
            ns.insert(contents, title);
          }
        else if(action.equals("view"))
          {
            request.setAttribute("edit", true);
            request.setAttribute("note", ns.get(Integer.valueOf(request.getParameter("id"))));
          }
        else if(action.equals("delete"))
          {
            request.setAttribute("edit", true);
            ns.delete(Integer.valueOf(request.getParameter("id")));
          }
        else if (action.equals("edit"))
          {
            request.setAttribute("edit", true);
           
            Note n = ns.get(Integer.valueOf(request.getParameter("id")));           
            ns.update(Integer.valueOf(request.getParameter("id")), title, contents);
             request.setAttribute("note", ns.get(Integer.valueOf(request.getParameter("id"))));
          }
        

        List<Note> notes = ns.getAll();
        request.setAttribute("notes", notes);

        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
      }

  }
