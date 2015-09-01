

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		List<Cart> cart = (List<Cart>) session.getAttribute("shopping_cart");
		String message = "";
		double total = 0;
		double sum = 0;
		String f_amount = "";
		message = "<thead><tr><th>You're Cart</th></tr></thead>";
		for(Cart loop: cart)
		{
			
			message += "<tr><td>Item: "+loop.getName()+"</td></tr>\n";
			message += "<tr><td>Price: "+loop.getPrice()+"</td></tr>\n";
			message += "<tr><td>Quantity: "+loop.getQuantity()+"</td></tr>\n";
			total = loop.getPrice()*loop.getQuantity();
			message += "<tr><td>Item total: "+total+"</td></tr>\n";
			sum += total;
		}
		
		
		message += "<tr><td>Total due is:  " +sum+ "</td></tr>\n";
		
		for (Cart list1 : cart)
		{
			System.out.println(list1.getName());
			System.out.println(list1.getPrice());
			System.out.println(list1.getQuantity());
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
