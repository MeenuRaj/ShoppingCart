

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Shoppingcart;
import model.User;
import customTools.DBUtil;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
	
		
	
		String message = "";
		String q="select u from User u ";
		
		TypedQuery<User>aq =em.createQuery(q,User.class);
		System.out.println(""+aq);
		List<User> list=aq.getResultList();
		System.out.println("query reult:"+aq.getResultList());
		message= "<div class=\"container\"> <div class=\"list-group\">";
		for(User temp:list)
		{	
			message+=" <div class=\"list-group-item\"> <p>"+temp.getUsername()+"</p><form class=\"form-inline\" role=\"form\" action =  \"AddCreditServlet\"  method =\"post\"> <input type=\"hidden\" name=\"action\" value=\""+temp.getUsername()+"\"/><div class=\"form-group\">  <label for=\"email\">Credit: $</label>"+
					"<input type=\"text\" class=\"form-control\" id=\"Credit\" name = \"Credit\">  </div> <button type=\"submit\" class=\"btn btn-default\">Add to Credit</button>  </form>	</div>";
         
		}

		message+="</div></div>";
	request.setAttribute("users", message);
	getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println(""+e.toString());
			System.out.println(""+e.getCause());
			System.out.println(""+e.getStackTrace());
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
