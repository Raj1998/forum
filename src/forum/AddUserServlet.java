package forum;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/AddUser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User u = new User();
		u.setUserEmail(email);
		u.setUserName(userName);
		u.setUserPassword(password);
		
		int status = UserDAO.addUser(u);
		if(status == 1) {
			System.out.println("user added");
			response.sendRedirect("index.jsp?msg=newUserAdded");
		} 
		else if(status == 0) {
			System.out.println("fail to add");
		}
		else {
			response.sendRedirect("signup.jsp?msg=multipleUsers");
			System.out.println("multiple users");
		}
		
	}

}
