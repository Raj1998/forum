package forum;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddNewPost
 */
@WebServlet("/AddNewPost")
public class AddNewPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewPost() {
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
		
		HttpSession session=request.getSession();
		String text = request.getParameter("text");
		int threadId = Integer.parseInt(request.getParameter("threadId"));
//		String tId = 
		int uid = (Integer) session.getAttribute("userId");
		
		
		Post p = new Post();
		p.setText(text);
		p.setThreadId(threadId);
		p.setUserId(uid);
		
		int status = PostDAO.addPost(p);
		if(status == 1) {
			response.sendRedirect("viewThread.jsp?id="+threadId);
		}
		else {
			
		}
	}

}
