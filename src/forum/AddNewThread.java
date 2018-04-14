package forum;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddNewThread
 */
@WebServlet("/AddNewThread")
public class AddNewThread extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewThread() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String title = request.getParameter("title");
		String subject = request.getParameter("subject");
		
		Threadd t = new Threadd();
		t.setTitle(title);
		t.setSubject(subject);
		
		int uid = (Integer) session.getAttribute("userId");
		
		int status = ThreadDAO.createThread(t, uid);
		if(status == 1) {
			System.out.println("Thread Created !!");
			response.sendRedirect("viewAllThreads.jsp");
		} 
		else if(status == 0) {
			System.out.println("fail to Create");
		}
		else {
			System.out.println("some problem");
		}
		
	}

}
