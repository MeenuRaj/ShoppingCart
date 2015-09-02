

import java.io.IOException;
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
import model.Shoppingcart;
import model.Shppingcartreview;
import customTools.DBUtil;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
    	EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
			try
		
		{
			int item_id = Integer.parseInt(request.getParameter("itemid"));
			
	
		String message = "";
		String message1 = "";
		String q="select s from Shoppingcart s where s.id="+item_id;
		
		TypedQuery<Shoppingcart>aq =em.createQuery(q,Shoppingcart.class);
		List<Shoppingcart> list=aq.getResultList();
	
		for(Shoppingcart temp:list)
		{	
			message+="<h1>"+temp.getItemname()+"</h1><h3>"+temp.getDescription()+"</h3><p>"+temp.getPrice()+"</p>";
			/*	+"<a class=\"btn btn-primary\" href=\"AddServlet?itemid="+item_id+"\"> Add to Cart </a>";*/
			message1+="<div class=\"container\">  <form class=\"form-inline\" role=\"form\" action =  \"AddServlet\"  method =\"post\"> <div class=\"form-group\">  <label for=\"email\">Quantity:</label>"+
			   "<input type=\"hidden\" name=\"action\" value=\""+temp.getId()+"\"/>";
			if(request.getSession().getAttribute("username")==null)
			{
				message1+=" </form>	</div>";
			}
			else
			{
				request.getSession().setAttribute("productID", temp.getId());
				System.out.println(temp.getId());
				message1+="  <input type=\"text\" class=\"form-control\" id=\"quantity\" name = \"quantity\">  </div>"+
			   " <button type=\"submit\" class=\"btn btn-default\">Add to Cart</button>  </form>	</div>";
				
			
					try
					{
				
					q="select s from Shppingcartreview s where s.productid= "+temp.getId();
					
					TypedQuery<Shppingcartreview>sq =em.createQuery(q,Shppingcartreview.class);
					List<Shppingcartreview> list2=sq.getResultList();
					
					for(Shppingcartreview temp2:list2)
					{	
						
						message1 += "<ul><il>User: "+temp2.getRUsername()+"</il>\n";
						message1 += "<il>Comment: "+temp2.getReviews()+"</il>\n";
						message1 += "<il>Rating: ";
						for(int i=0; i<temp2.getRating().intValue();i++)
							{
							message1 += "<img src=\"star.png\" height=\"32\" width=\"32\">";
							}
						message1 += "</il>\n";
						message1 += "<il>Date: "+temp2.getDates()+"</il>\n</ul>";      

					}
					}
					catch(Exception e)
					{
						System.out.println(""+e.toString());
						System.out.println(""+e.getCause());
						System.out.println(""+e.getStackTrace());
					}
			
				message1+="  <form class=\"form-inline\" role=\"form\" action =  \"ReviewServlet\"  method =\"post\"> <div class=\"form-group\">  <label >Comment:</label>"+
			  "<input type=\"text\" class=\"form-control\" id=\"comment\" name = \"comment\"> <div class=\"form-group\"> <label >Rating:</label>	<label class=\"radio-inline\"> <input type=\"radio\""+
					"name=\"optradio\" value=1>1 Star</label> <label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\" value=2>2 Star</label> <label class=\"radio-inline\"><input type=\"radio\""
				+"name=\"optradio\" value=3>3 Star</label><label class=\"radio-inline\"> <input type=\"radio\"name=\"optradio\" value=4>4 Star	</label><label class=\"radio-inline\"> <input type=\"radio\""
				+"	name=\"optradio\" value=5>5 Star		</label>	</div>"+
						   " <button type=\"submit\" class=\"btn btn-default\">Submit Review</button>  </form>	</div>";
			}
			
		}	
		request.setAttribute("quantity",message1);
	request.setAttribute("item", message);

	getServletContext().getRequestDispatcher("/details.jsp").forward(request, response);

		}
		catch(Exception e)
		{
			System.out.println(""+e.getStackTrace());

		}
		
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}