

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
		
		Cart myCart = new Cart();
		HttpSession session = request.getSession();
		ArrayList<Cart> myArray;
		if(session.getAttribute("shopping_cart")==null)
		{
			myArray = new ArrayList<Cart>();
		}
		else
		{
			myArray = (ArrayList<Cart>)session.getAttribute("shopping_cart");
		}
	
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		model.Shoppingcart shop = new model.Shoppingcart();
		
		//message= "<thead><tr><th>Student ID</th><th>Class</th><th>Assignment</th><th>Assignment Type</th><th>Date</th><th>Garde</th></tr></thead>";
		

		
		
		
		if(request.getParameter("action").equals("bbshampoo"))
		{
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String q = "select s from Shoppingcart s where s.id = 1";
			TypedQuery<Shoppingcart> bq = em.createQuery(q, Shoppingcart.class);
			List<Shoppingcart> list = bq.getResultList();
			for (Shoppingcart temp : list) {
				myCart.setName(temp.getItemname());
				myCart.setPrice(temp.getPrice().doubleValue());
				myCart.setQuantity(quantity);
			}
			
			myArray.add(myCart);
			getServletContext().getRequestDispatcher("/bbshampoo.jsp").forward(request,  response);
		}
		
		if(request.getParameter("action").equals("bbconditioner"))
		{
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String q = "select s from Shoppingcart s where s.id = 2";
			TypedQuery<Shoppingcart> bq = em.createQuery(q, Shoppingcart.class);
			List<Shoppingcart> list = bq.getResultList();
			for (Shoppingcart temp : list) {
				myCart.setName(temp.getItemname());
				myCart.setPrice(temp.getPrice().doubleValue());
				myCart.setQuantity(quantity);
			}
			
			myArray.add(myCart);
			getServletContext().getRequestDispatcher("/bbconditioner.jsp").forward(request,  response);
		}
		
		
		if(request.getParameter("action").equals("gloss"))
		{
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String q = "select s from Shoppingcart s where s.id = 3";
			TypedQuery<Shoppingcart> bq = em.createQuery(q, Shoppingcart.class);
			List<Shoppingcart> list = bq.getResultList();
			for (Shoppingcart temp : list) {
				myCart.setName(temp.getItemname());
				myCart.setPrice(temp.getPrice().doubleValue());
				myCart.setQuantity(quantity);
			}
			
			myArray.add(myCart);
		}
		
		
		if(request.getParameter("action").equals("foam"))
		{
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String q = "select s from Shoppingcart s where s.id = 4";
			TypedQuery<Shoppingcart> bq = em.createQuery(q, Shoppingcart.class);
			List<Shoppingcart> list = bq.getResultList();
			for (Shoppingcart temp : list) {
				myCart.setName(temp.getItemname());
				myCart.setPrice(temp.getPrice().doubleValue());
				myCart.setQuantity(quantity);
			}
			
			myArray.add(myCart);
		}
		
		
		if(request.getParameter("action").equals("heat"))
		{
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String q = "select s from Shoppingcart s where s.id = 5";
			TypedQuery<Shoppingcart> bq = em.createQuery(q, Shoppingcart.class);
			List<Shoppingcart> list = bq.getResultList();
			for (Shoppingcart temp : list) {
				myCart.setName(temp.getItemname());
				myCart.setPrice(temp.getPrice().doubleValue());
				myCart.setQuantity(quantity);
			}
			
			myArray.add(myCart);
		}
		
		
		if(request.getParameter("action").equals("moroccon"))
		{
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String q = "select s from Shoppingcart s where s.id = 6";
			TypedQuery<Shoppingcart> bq = em.createQuery(q, Shoppingcart.class);
			List<Shoppingcart> list = bq.getResultList();
			for (Shoppingcart temp : list) {
				myCart.setName(temp.getItemname());
				myCart.setPrice(temp.getPrice().doubleValue());
				myCart.setQuantity(quantity);
			}
			
			myArray.add(myCart);
		}

		if(request.getParameter("action").equals("curl"))
		{
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String q = "select s from Shoppingcart s where s.id = 7";
			TypedQuery<Shoppingcart> bq = em.createQuery(q, Shoppingcart.class);
			List<Shoppingcart> list = bq.getResultList();
			for (Shoppingcart temp : list) {
				myCart.setName(temp.getItemname());
				myCart.setPrice(temp.getPrice().doubleValue());
				myCart.setQuantity(quantity);
			}
			
			myArray.add(myCart);
		}
		
		
		if(request.getParameter("action").equals("pmshampoo"))
		{
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String q = "select s from Shoppingcart s where s.id = 8";
			TypedQuery<Shoppingcart> bq = em.createQuery(q, Shoppingcart.class);
			List<Shoppingcart> list = bq.getResultList();
			for (Shoppingcart temp : list) {
				myCart.setName(temp.getItemname());
				myCart.setPrice(temp.getPrice().doubleValue());
				myCart.setQuantity(quantity);
			}
			
			myArray.add(myCart);
		}
		
		
		if(request.getParameter("action").equals("pmconditioner"))
		{
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String q = "select s from Shoppingcart s where s.id = 9";
			TypedQuery<Shoppingcart> bq = em.createQuery(q, Shoppingcart.class);
			List<Shoppingcart> list = bq.getResultList();
			for (Shoppingcart temp : list) {
				myCart.setName(temp.getItemname());
				myCart.setPrice(temp.getPrice().doubleValue());
				myCart.setQuantity(quantity);
			}
			
			myArray.add(myCart);
		}
		
		
		if(request.getParameter("action").equals("pmconditioner"))
		{
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String q = "select s from Shoppingcart s where s.id = 9";
			TypedQuery<Shoppingcart> bq = em.createQuery(q, Shoppingcart.class);
			List<Shoppingcart> list = bq.getResultList();
			for (Shoppingcart temp : list) {
				myCart.setName(temp.getItemname());
				myCart.setPrice(temp.getPrice().doubleValue());
				myCart.setQuantity(quantity);
			}
			
			myArray.add(myCart);
		}
		
		
		if(request.getParameter("action").equals("oil"))
		{
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String q = "select s from Shoppingcart s where s.id = 10";
			TypedQuery<Shoppingcart> bq = em.createQuery(q, Shoppingcart.class);
			List<Shoppingcart> list = bq.getResultList();
			for (Shoppingcart temp : list) {
				myCart.setName(temp.getItemname());
				myCart.setPrice(temp.getPrice().doubleValue());
				myCart.setQuantity(quantity);
			}
			
			myArray.add(myCart);
		}
		
		System.out.println(myArray);
		session.setAttribute("shopping_cart", myArray);
		
	/*	for (Cart list1 : myArray)
		{
			System.out.println(list1.getName());
			System.out.println(list1.getPrice());
			System.out.println(list1.getQuantity());
		}*/
	
	/*	response.setContentType("text/html");
	      getServletContext()
	      .getRequestDispatcher("/output.jsp")
	      .forward(request,  response);*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
