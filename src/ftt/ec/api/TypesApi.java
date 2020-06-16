package ftt.ec.api;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ftt.ec.beans.Types;
import ftt.ec.model.TypesDAO;

/**
 * Servlet implementation class TypesApi
 */
@WebServlet("/TypesApi")
public class TypesApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypesApi() {
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
				
		System.out.println("Types get - " + new Date());
		
		Types t = new Types();
		
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Pokemon(seters)		
		t.setId(request.getParameter("ID"));
		t.setName(request.getParameter("NAME"));
		t.setBiggest_weakness(request.getParameter("BIGGEST_WEAKNESS"));
		t.setBiggest_advantage(request.getParameter("BIGGEST_ADVANTAGE"));
		
		TypesDAO typesDAO = new TypesDAO();		
		typesDAO.find(t);	
		//typesDAO.insert(t);

		//TODO: Gerenciar e propagar erro...
						
		//System.out.println(request.getContentLength());		
		if (request.getContentLength() < 1) {
			response.getWriter().append("{\"count\":" + typesDAO.count() + "}");
		} else {
			response.getWriter().append("Type selected...");//***********************
		} //if		
	} //doGet SELECT E FIND

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Types post - " + new Date());
		//doGet(request, response);

		Types t = new Types();
						
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Types (seters)		
		t.setId(request.getParameter("ID"));
		t.setName(request.getParameter("NAME"));
		t.setBiggest_weakness(request.getParameter("BIGGEST_WEAKNESS"));
		t.setBiggest_advantage(request.getParameter("BIGGEST_ADVANTAGE"));
        
		TypesDAO typesDAO = new TypesDAO();		
		typesDAO.insert(t);

		//TODO: Gerenciar e propagar erro...
						
		//System.out.println(request.getContentLength());		
		if (request.getContentLength() < 1) {
			response.getWriter().append("{\"count\":" + typesDAO.count() + "}");
		} else {
			response.getWriter().append("Type created...");
		} //if		
	}//doPost INSERT

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Types put - " + new Date());
		
		Types t = new Types();
		
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Types (seters)		
		t.setId(request.getParameter("ID"));
		t.setName(request.getParameter("NAME"));
		t.setBiggest_weakness(request.getParameter("BIGGEST_WEAKNESS"));
		t.setBiggest_advantage(request.getParameter("BIGGEST_ADVANTAGE"));
        
		TypesDAO typesDAO = new TypesDAO();		
		typesDAO.update(t);

		//TODO: Gerenciar e propagar erro...
						
		//System.out.println(request.getContentLength());		
		if (request.getContentLength() < 1) {
			response.getWriter().append("{\"count\":" + typesDAO.count() + "}");
		} else {
			response.getWriter().append("Type updated...");
		} //if		
	}//doPut UPDATE

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Types delete - " + new Date());		
		Types t = new Types();		
		t.setId(request.getParameter("ID"));//getParamtere retorna string, conversão é feita na classe Pokemon (seters)	
		System.out.println("Delete: " + t.getId());
						
		TypesDAO typesDAO = new TypesDAO();		
		typesDAO.delete(t);
						
		//TODO: Implementar processamento de erro apropriado...
		response.getWriter().append("Type deleted...");		
	} //doDelete

}
