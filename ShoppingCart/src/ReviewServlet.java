

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

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import customTools.DBUtil;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String comment = request.getParameter("comment");
		int rating = Integer.parseInt(request.getParameter("optradio"));
		int itemID = Integer.parseInt(request.getSession().getAttribute("productID").toString());
		String uid = (String) request.getSession().getAttribute("username");
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		model.Shppingcartreview review = new model.Shppingcartreview();
		trans.begin();
		Date d = new Date();
		try {
			
			review.setProductid(BigDecimal.valueOf(itemID));
			review.setRating(BigDecimal.valueOf(rating));
			review.setReviews(comment);
			review.setRUsername(uid);
			review.setDates(d);
			em.persist(review);
			trans.commit();	
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
			trans.rollback();
		} 
		getServletContext().getRequestDispatcher("/DetailServlet?itemid="+itemID).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

doGet(request, response);
	}

}
