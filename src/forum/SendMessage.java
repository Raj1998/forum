package forum;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SendMessage
 */
@WebServlet("/SendMessage")
public class SendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessage() {
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
		String receiver = request.getParameter("receiver");
		int rec_id = UserDAO.getUserByName(receiver);
		String title = request.getParameter("title");
		String subject = request.getParameter("subject");
		HttpSession session=request.getSession();
		int s_id = (Integer) session.getAttribute("userId");
		
		Message m = new Message();
		m.setMessage(subject);
		m.setR_id(rec_id);
		m.setTitle(title);
		m.setS_id(s_id);
		m.setS_status(1);
		m.setR_status(0);
		
		int status = UserDAO.sendMessage(m);
		System.out.println(status);
		if(status == 1) {
			response.sendRedirect("index.jsp?msg=sent");
		}
		else if(status == -1) {
			response.sendRedirect("index.jsp?msg=wrongUserName");
		}
		else {
			response.sendRedirect("index.jsp?msg=errInSending");
		}
		
	}

}
