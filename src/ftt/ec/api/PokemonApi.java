package ftt.ec.api;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ftt.ec.beans.Pokemon;
import ftt.ec.model.PokemonDAO;

/**
 * Servlet implementation class PokemonApi
 */
@WebServlet("/PokemonApi")
public class PokemonApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private HashMap<String, String> userData;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PokemonApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//this.userData = new HashMap<String, String>(); //ID, Name
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
		
		System.out.println("Pokemon get - " + new Date());

		// TODO Auto-generated method stub
		Pokemon p = new Pokemon();
				
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Pokemon(seters)		
		p.setId(request.getParameter("ID"));
		p.setName(request.getParameter("NAME"));
		p.setNumber(request.getParameter("NUMBER"));
		p.setType(request.getParameter("TYPE"));
		         
		PokemonDAO pokemonDAO = new PokemonDAO();		
		//pokemonDAO.insert(p);
		//pokemonDAO.update(p);
		pokemonDAO.find(p);

		//TODO: Gerenciar e propagar erro...
				
		//System.out.println(request.getContentLength());		
		if (request.getContentLength() < 1) {
			response.getWriter().append("{\"count\":" + pokemonDAO.count() + "}");
		} else {
			response.getWriter().append("Pokemon selected...");//********************
		} //if
	} //doGet SELECT E FIND
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Pokemon post - " + new Date());
		//doGet(request, response);
		Pokemon p = new Pokemon();
		
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Pokemon(seters)		
		p.setId(request.getParameter("ID"));
		p.setName(request.getParameter("NAME"));
		p.setNumber(request.getParameter("NUMBER"));
		p.setType(request.getParameter("TYPE"));
		         
		PokemonDAO pokemonDAO = new PokemonDAO();		
		pokemonDAO.insert(p);
		//pokemonDAO.update(p);
		//pokemonDAO.find(p);

		//TODO: Gerenciar e propagar erro...
				
		//System.out.println(request.getContentLength());		
		if (request.getContentLength() < 1) {
			response.getWriter().append("{\"count\":" + pokemonDAO.count() + "}");
		} else {
			response.getWriter().append("Pokemon created...");
		} //if
	}//doPost INSERT
	
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Pokemon put - " + new Date());
		
		Pokemon p = new Pokemon();
		
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Pokemon(seters)		
		p.setId(request.getParameter("ID"));
		p.setName(request.getParameter("NAME"));
		p.setNumber(request.getParameter("NUMBER"));
		p.setType(request.getParameter("TYPE"));
		         
		PokemonDAO pokemonDAO = new PokemonDAO();		
		pokemonDAO.update(p);
		//pokemonDAO.insert(p);
		//pokemonDAO.find(p);

		//TODO: Gerenciar e propagar erro...
				
		//System.out.println(request.getContentLength());		
		if (request.getContentLength() < 1) {
			response.getWriter().append("{\"count\":" + pokemonDAO.count() + "}");
		} else {
			response.getWriter().append("Pokemon updated...");
		} //if
	}//doPut UPDATE

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Pokemon delete - " + new Date());		
		Pokemon p = new Pokemon();		
		p.setId(request.getParameter("ID"));//getParamtere retorna string, conversão é feita na classe Pokemon (seters)	
		System.out.println("Delete: " + p.getId());
				
		PokemonDAO pokemonDAO = new PokemonDAO();		
        pokemonDAO.delete(p);
				
		//TODO: Implementar processamento de erro apropriado...
		response.getWriter().append("Pokemon deleted...");		
	} //doDelete
}
