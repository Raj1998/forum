package forum;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		
		User u = UserDAO.authenticate(userName, password);
		
		if(u == null) {
			response.sendRedirect("login.jsp?validation=failed");
		}
		else {
			request.getSession().setAttribute("userName", userName);
			request.getSession().setAttribute("userId", u.getUserId());
			
			response.sendRedirect("index.jsp");
		}

	}

}
