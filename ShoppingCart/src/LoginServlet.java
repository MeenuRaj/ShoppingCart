

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import model.Cart;
import model.User;
import customTools.DBUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
	
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		model.User acc = new model.User();
		String message = "";
		HttpSession session = request.getSession();

		
//			acc.setUsername(password);
			session.setAttribute("username", username);
			String q="select u from User u where u.username ='"+username+"'";
			System.out.println(q);
			TypedQuery<User>aq =em.createQuery(q,User.class);
			System.out.println(aq);
			List<User> list1=aq.getResultList();
			System.out.println("query reult:"+aq.getResultList());
			if (list1 == null || list1.isEmpty())
			{
				message = "Incorrect username or password";
				response.setContentType("text/html");
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
			}
			else	
				{
				ArrayList<CartObj> myArray = new ArrayList<CartObj>();
				String q2 = "select c from Cart c where c.cUname ='" +username+"'";
				TypedQuery<Cart> bq2 = em.createQuery(q2, Cart.class);
				List<Cart> list = bq2.getResultList();
				for (Cart temp : list) {
					CartObj myCart =new CartObj();
					myCart.setName(temp.getProduct());
					myCart.setPrice(temp.getPrice().doubleValue());
					myCart.setQuantity(temp.getQuantity().intValue());
					myArray.add(myCart);
				}
				session.setAttribute("shopping_cart", myArray);
					getServletContext().getRequestDispatcher("/loggedin.jsp").forward(request, response);

				
				
				}
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
