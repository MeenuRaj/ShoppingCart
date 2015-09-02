

import java.io.IOException;
import java.util.ArrayList;
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

import model.Cart;
import model.Shoppingcart;
import customTools.DBUtil;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//CartObj myCart = new CartObj();
		
		String uid = (String) request.getSession().getAttribute("username");
		int item_id = Integer.parseInt(request.getParameter("action"));
		//ArrayList<CartObj> myArray;
		System.out.println(item_id);
		/*if(request.getSession().getAttribute("shopping_cart")==null)
		{
			System.out.println("in if");
			myArray = new ArrayList<CartObj>();
			String q = "select c from Cart c where c.cUname ='" +uid+"'";
			TypedQuery<Cart> bq = em.createQuery(q, Cart.class);
			List<Cart> list = bq.getResultList();
			for (Cart temp : list) {
				myCart.setName(temp.getProduct());
				myCart.setPrice(temp.getPrice().doubleValue());
				myCart.setQuantity(temp.getQuantity().intValue());
				myArray.add(myCart);
			}
			
		}
		else
		{
		System.out.println("this works");
			myArray = (ArrayList<CartObj>)request.getSession().getAttribute("shopping_cart");
				
		//message= "<thead><tr><th>Student ID</th><th>Class</th><th>Assignment</th><th>Assignment Type</th><th>Date</th><th>Garde</th></tr></thead>";

			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String q = "select s from Shoppingcart s where s.id = " +item_id;
			TypedQuery<Shoppingcart> bq = em.createQuery(q, Shoppingcart.class);
			List<Shoppingcart> list = bq.getResultList();
			for (Shoppingcart temp : list) {
				System.out.println("this works");
				myCart.setName(temp.getItemname());
				myCart.setPrice(temp.getPrice().doubleValue());
				myCart.setQuantity(quantity);
				myArray.add(myCart);
			}
			
				
		}*/
		
		ArrayList<CartObj> myArray;
		if(request.getSession().getAttribute("shopping_cart")==null)
		{
			myArray =new ArrayList<CartObj>();
			
		}
	
		myArray=(ArrayList<CartObj>) request.getSession().getAttribute("shopping_cart");
		
		
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String q2 = "select s from Shoppingcart s where s.id = " +item_id;
		
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

		TypedQuery<Shoppingcart> bq2 = em.createQuery(q2, Shoppingcart.class);
		List<Shoppingcart> list2 = bq2.getResultList();
		CartObj myCart =new CartObj(); 
		System.out.println("this is my array "+myArray);
		for (Shoppingcart temp : list2) {
			System.out.println("this works");
			myCart.setName(temp.getItemname());
			myCart.setPrice(temp.getPrice().doubleValue());
			myCart.setQuantity(quantity);
			myArray.add(myCart);
		}
		
	
	
		System.out.println(myArray);
		request.getSession().setAttribute("shopping_cart", myArray);
		
		getServletContext().getRequestDispatcher("/confirmation.jsp").forward(request,  response);
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
