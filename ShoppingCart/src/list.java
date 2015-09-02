

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
import customTools.DBUtil;

/**
 * Servlet implementation class list
 */
@WebServlet("/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public list() {
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
	
		Shoppingcart items = new Shoppingcart();
	
		String message = "";
		String q="select s from Shoppingcart s ";
		
		TypedQuery<Shoppingcart>aq =em.createQuery(q,Shoppingcart.class);
		System.out.println(""+aq);
		List<Shoppingcart> list=aq.getResultList();
		System.out.println("query reult:"+aq.getResultList());
		message= "";
		for(Shoppingcart temp:list)
		{	
			message+=" <a href=\"DetailServlet?itemid="+temp.getId()+"\" class=\"list-group-item\">"+temp.getItemname()+"</a>";          

		}
 	   
	request.setAttribute("products", message);
	getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
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
		doGet(request,response);
	}

}