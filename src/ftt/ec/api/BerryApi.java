package ftt.ec.api;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ftt.ec.beans.Berry;
import ftt.ec.model.BerryDao;

/**
 * Servlet implementation class MovesApi
 */
@WebServlet("/BerryApi")
public class BerryApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BerryApi() {
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
				
		System.out.println("Berry get - " + new Date());
		// TODO Auto-generated method stub
		Berry b = new Berry();
						
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Pokemon(seters)		
		b.setId(request.getParameter("ID"));
		b.setName(request.getParameter("NAME"));
		b.setGrowth(request.getParameter("GROWTH_TIME"));
				         
		BerryDao berryDao = new BerryDao();		
		//pokemonDAO.insert(p);
		//pokemonDAO.update(p);
		berryDao.find(b);

		//TODO: Gerenciar e propagar erro...
						
		//System.out.println(request.getContentLength());		
		if (request.getContentLength() < 1) {
			response.getWriter().append("{\"count\":" + berryDao.count() + "}");
		} else {
			response.getWriter().append("Berry selected...");//********************
		} //if
	} //doGet	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Berry post - " + new Date());
		//doGet(request, response);
		Berry b = new Berry();
				
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Pokemon(seters)		
		p.setId(request.getParameter("ID"));
		p.setName(request.getParameter("NAME"));
		b.setGrowth(request.getParameter("GROWTH_TIME"));
		
		BerryDao berryDao = new BerryDao();		
		berryDao.insert(p);
		

		//TODO: Gerenciar e propagar erro...
						
		//System.out.println(request.getContentLength());
		if (request.getContentLength() < 1) {
			response.getWriter().append("{\"count\":" + berryDao.count() + "}");
		} else {
			response.getWriter().append("Berry created...");
		} //if
	}//doPost

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Berry post - " + new Date());
		//doGet(request, response);
		Berry b = new Berry();
				
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Pokemon(seters)		
		p.setId(request.getParameter("ID"));
		p.setName(request.getParameter("NAME"));
		b.setGrowth(request.getParameter("GROWTH_TIME"));
		
		BerryDao berryDao = new BerryDao();		
		berryDao.update(p);
		

		//TODO: Gerenciar e propagar erro...
						
		//System.out.println(request.getContentLength());
		if (request.getContentLength() < 1) {
			response.getWriter().append("{\"count\":" + berryDao.count() + "}");
		} else {
			response.getWriter().append("Berry updated...");
		}
	}//doPut

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Berry delete - " + new Date());		
		Berry b = new Berry();				
		b.setId(request.getParameter("ID"));
		System.out.println("Delete: " + b.getId());
		
		BerryDao berryDao = new BerryDao();		
		berryDao.delete(b);
		
		//TODO: Implementar processamento de erro apropriado...
		response.getWriter().append("Berry deleted...");		
	} //doDelete
}