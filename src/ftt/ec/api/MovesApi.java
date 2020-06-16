package ftt.ec.api;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ftt.ec.beans.Moves;
import ftt.ec.model.MovesDAO;

/**
 * Servlet implementation class MovesApi
 */
@WebServlet("/MovesApi")
public class MovesApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovesApi() {
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
		
		System.out.println("Moves get - " + new Date());

		// TODO Auto-generated method stub
		Moves m = new Moves();
		
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Moves(seters)		
		m.setId(request.getParameter("ID"));
        m.setName(request.getParameter("NAME"));
        m.setPower(request.getParameter("POWER"));
        m.setAccuracy(request.getParameter("ACCURACY"));
        m.setType(request.getParameter("TYPE"));		 
         
		MovesDAO movesDAO = new MovesDAO();
		movesDAO.find(m);
		//movesDAO.insert(m);

        //TODO: Gerenciar e propagar erro...
		
		//System.out.println(request.getContentLength());		
		if (request.getContentLength() < 1) {
			response.getWriter().append("{\"count\":" + movesDAO.count() + "}");
		} else {
			response.getWriter().append("Move selected...");//*******************
		} //if
	} //doGet SELECT E FIND

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Moves post - " + new Date());
		//doGet(request, response);
		Moves m = new Moves();
		
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Moves(seters)		
		m.setId(request.getParameter("ID"));
        m.setName(request.getParameter("NAME"));
        m.setPower(request.getParameter("POWER"));
        m.setAccuracy(request.getParameter("ACCURACY"));
        m.setType(request.getParameter("TYPE"));		 
         
		MovesDAO movesDAO = new MovesDAO();
		//movesDAO.find(m);
		movesDAO.insert(m);

        //TODO: Gerenciar e propagar erro...
		
		//System.out.println(request.getContentLength());		
		if (request.getContentLength() < 1) {
			response.getWriter().append("{\"count\":" + movesDAO.count() + "}");
		} else {
			response.getWriter().append("Move created...");
		} //if
	}//doPost INSERT

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Moves m = new Moves();
		
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Moves(seters)		
		m.setId(request.getParameter("ID"));
        m.setName(request.getParameter("NAME"));
        m.setPower(request.getParameter("POWER"));
        m.setAccuracy(request.getParameter("ACCURACY"));
        m.setType(request.getParameter("TYPE"));		 
        
		MovesDAO movesDAO = new MovesDAO();
		movesDAO.update(m);
		//movesDAO.find(m);
		//movesDAO.insert(m);

        //TODO: Gerenciar e propagar erro...
		
		//System.out.println(request.getContentLength());		
		if (request.getContentLength() < 1) {
			response.getWriter().append("{\"count\":" + movesDAO.count() + "}");
		} else {
			response.getWriter().append("Move updated...");
		} //if
		System.out.println("Moves put - " + new Date());
	}//doPut UPDATE

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Moves delete - " + new Date());		
		Moves m = new Moves();				
		m.setId(request.getParameter("ID"));//getParamtere retorna string, conversão é feita na classe Moves (seters)	
		System.out.println("Delete: " + m.getId());
		
		MovesDAO movesDAO = new MovesDAO();		
		movesDAO.delete(m);
		
		//TODO: Implementar processamento de erro apropriado...
		response.getWriter().append("Move deleted...");		
	} //doDelete
}
