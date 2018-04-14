package forum;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditThread
 */
@WebServlet("/EditThread")
public class EditThread extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditThread() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String subject = request.getParameter("subject");
		String id = request.getParameter("id");
		
		Threadd t = new Threadd();
		t.setTitle(title);
		t.setSubject(subject);
		t.setThreadId(Integer.parseInt(id));
		
		int status = ThreadDAO.updateThread(t);
		if(status == 1) {
			System.out.println("Thread updated !!");
			response.sendRedirect("viewAllThreads.jsp");
		} 
		else if(status == 0) {
			System.out.println("fail to update");
		}
		else {
			System.out.println("some problem");
		}
	}

}
