package ftt.ec.api;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ftt.ec.beans.Item;
import ftt.ec.model.ItemDao;

/**
 * Servlet implementation class MovesApi
 */
@WebServlet("/ItemApi")
public class ItemApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("Item get - " + new Date());

		// TODO Auto-generated method stub
		Item i = new Item();
		
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Moves(seters)		
		b.setId(request.getParameter("ID"));
        b.setName(request.getParameter("NAME"));
        b.setRarity(request.getParameter("RARITY"));		 
         
		ItemDao itemDao = new ItemDao();		
		itemDao.find(i);

        //TODO: Gerenciar e propagar erro...
		
		//System.out.println(request.getContentLength());		
		if (request.getContentLength() < 1) {
			response.getWriter().append("{\"count\":" + itemDao.count() + "}");
		} else {
			response.getWriter().append("Item selected...");
		} //if
	} //doGet	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Item post - " + new Date());

		// TODO Auto-generated method stub
		Item i = new Item();
		
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Moves(seters)		
		b.setId(request.getParameter("ID"));
        b.setName(request.getParameter("NAME"));
        b.setRarity(request.getParameter("RARITY"));		 
         
		ItemDao itemDao = new ItemDao();		
		itemDao.insert(i);

        //TODO: Gerenciar e propagar erro...
		
		//System.out.println(request.getContentLength());		
		if (request.getContentLength() < 1) {
			response.getWriter().append("{\"count\":" + itemDao.count() + "}");
		} else {
			response.getWriter().append("Item created...");
		}
	}//doPost

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Item put - " + new Date());

		// TODO Auto-generated method stub
		Item i = new Item();
		
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Moves(seters)		
		b.setId(request.getParameter("ID"));
        b.setName(request.getParameter("NAME"));
        b.setRarity(request.getParameter("RARITY"));		 
         
		ItemDao itemDao = new ItemDao();		
		itemDao.update(i);

        //TODO: Gerenciar e propagar erro...
		
		//System.out.println(request.getContentLength());		
		if (request.getContentLength() < 1) {
			response.getWriter().append("{\"count\":" + itemDao.count() + "}");
		} else {
			response.getWriter().append("Item update...");
		}
	}//doPut

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Item delete - " + new Date());		
		Item i = new Item();				
		i.setId(request.getParameter("ID"));
		System.out.println("Delete: " + i.getId());
		
		ItemDao itemDao = new ItemDao();		
		itemDao.delete(i);
		
		//TODO: Implementar processamento de erro apropriado...
		response.getWriter().append("Item deleted...");		
	} //doDelete
}