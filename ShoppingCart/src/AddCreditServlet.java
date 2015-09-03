

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import customTools.DBUtil;

/**
 * Servlet implementation class AddCreditServlet
 */
@WebServlet("/AddCreditServlet")
public class AddCreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCreditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("action");
		double credit = Double.parseDouble(request.getParameter("Credit"));
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		User user = new User();
		trans.begin();
		try {
			
			String q="update User u set u.credit="+credit+" where u.username='"+username+"'";
			System.out.println(q);
			em.createQuery(q).executeUpdate();
			trans.commit();	
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
			trans.rollback();
		} 
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
