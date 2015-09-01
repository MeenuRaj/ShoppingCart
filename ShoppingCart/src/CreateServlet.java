

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.User;
import customTools.DBUtil;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String new_username = request.getParameter("new_username");
		session.setAttribute("username", new_username);
		String message = "";
		
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		model.User user = new model.User();
		trans.begin();
		try {
			
			String fName = request.getParameter("new_name");
			user.setFName(fName);
			
			String a_uname = request.getParameter("new_username");
			user.setUsername(a_uname);
			
			String email = request.getParameter("new_email");
			user.setEmail(email);
			
			String password = request.getParameter("new_password");
			user.setAPassword(password);
			
			em.persist(user);
			trans.commit();	
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
			trans.rollback();
		} 
		
		
	
	getServletContext().getRequestDispatcher("/loggedin.jsp").forward(request, response);
		
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
