

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

import customTools.DBUtil;
import model.Cart;
import model.Shoppingcart;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true); 
		String uid = (String) session.getAttribute("username");
		System.out.println("the session userid is "+uid);
		String message = "";
		double total = 0;
		double tax = 0;
		double sum = 0;
		String f_amount = "";
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		if(uid.equals("admin"))
		{
			
			try
			{
		
			String q="select c from Cart c ";
			
			TypedQuery<Cart>aq =em.createQuery(q,Cart.class);
			List<Cart> list=aq.getResultList();
			for(Cart temp:list)
			{	
				message += "<tr><td>User: "+temp.getCUname()+"</td></tr>\n";
				message += "<tr><td>Item: "+temp.getProduct()+"</td></tr>\n";
				message += "<tr><td>Quantity: "+temp.getQuantity()+"</td></tr>\n";
				message += "<tr><td>Price: "+temp.getPrice()+"</td></tr>\n";        

			}
			}
			catch(Exception e)
			{
				System.out.println(""+e.toString());
				System.out.println(""+e.getCause());
				System.out.println(""+e.getStackTrace());
			}
		
		}
		else
		{
			ArrayList<CartObj> myArray;
			if(request.getSession().getAttribute("shopping_cart")==null)
			{
				message = "<thead><tr><th>"+uid+" Cart</th></tr></thead>";
			//	CartObj myCart = new CartObj();
				//smyArray = new ArrayList<CartObj>();
				String q = "select c from Cart c where c.cUname ='" +uid+"'";
				System.out.println(q);
				TypedQuery<Cart> bq = em.createQuery(q, Cart.class);
				List<Cart> list = bq.getResultList();
				for (Cart temp : list) {
					message += "<tr><td>Item: "+temp.getProduct()+"</td></tr>\n";
					message += "<tr><td>Price: "+temp.getPrice()+"</td></tr>\n";
					message += "<tr><td>Quantity: "+temp.getQuantity()+"</td></tr>\n";
					total = temp.getPrice().doubleValue()*temp.getQuantity().intValue();
					message += "<tr><td>Item total: "+total+"</td></tr>\n";
					tax = total*0.06;
					total = total + tax;
					message += "<tr><td>Item tax: "+tax+"</td></tr>\n";
					message += "<tr><td>Order total: "+total+"</td></tr>\n";
					sum += total;
					/*System.out.println(temp.getProduct());
					myCart.setName(temp.getProduct());
					myCart.setPrice(temp.getPrice().doubleValue());
					myCart.setQuantity(temp.getQuantity().intValue());*/
				//	myArray.add(myCart);
				}
				message += "<tr><td>Total due is:  " +sum+ "</td></tr>\n";		
		
			}
			else
			{
				List<CartObj> cart = (List<CartObj>) request.getSession().getAttribute("shopping_cart");
				message = "<thead><tr><th>You're Cart</th></tr></thead>";
				
				
				for(CartObj loop: cart)
				{
					
					message += "<tr><td>Item: "+loop.getName()+"</td></tr>\n";
					message += "<tr><td>Price: "+loop.getPrice()+"</td></tr>\n";
					message += "<tr><td>Quantity: "+loop.getQuantity()+"</td></tr>\n";
					total = loop.getPrice()*loop.getQuantity();
					message += "<tr><td>Item total: "+total+"</td></tr>\n";
					tax = total*0.06;
					total = total + tax;
					message += "<tr><td>Item tax: "+tax+"</td></tr>\n";
					message += "<tr><td>Order total: "+total+"</td></tr>\n";
					sum += total;
				}
				
				
				message += "<tr><td>Total due is:  " +sum+ "</td></tr>\n";
				

			}
			}
		
		
		request.setAttribute("message", message);
		
		response.setContentType("text/html");
	      getServletContext()
	      .getRequestDispatcher("/output.jsp")
	      .forward(request,  response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
