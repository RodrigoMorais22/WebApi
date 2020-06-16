package ftt.ec.api;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ftt.ec.control.BigIntControl;
//APIs devem ter pouco código, 
//processamento de dados deve ser 
//feito em outro lugar

/**
 * Servlet implementation class WebApiCalcula
 */
@WebServlet("/WebApiCalcula")
public class WebApiCalcula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebApiCalcula() {
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
		
		System.out.println("Passei no GET!");
		
		BigIntControl bi = new BigIntControl(
				request.getParameter("a"),
				request.getParameter("b"));
		response.getWriter().append(bi.getSum());
		
		/*	BIG INTEGER V1
		BigIntControl bi = new BigIntControl();
		bi.setA(request.getParameter("a"));
		bi.setB(request.getParameter("b"));
		response.getWriter().append(bi.getSum());
		*/
		
		/*	LONG ERRADO?
		long a = Integer.valueOf(request.getParameter("a"));
		long b = Integer.valueOf(request.getParameter("b"));
		// TODO Auto-generated method stub
		response.getWriter().append(String.valueOf(a+b));
		*/
		
		/*	BIG INTEGER ERRADO
		BigInteger a = new BigInteger(request.getParameter("a"));
		BigInteger b = new BigInteger(request.getParameter("b"));		
		// TODO Auto-generated method stub
		response.getWriter().append((b.add(a)).toString());
		*/
	
		/* SOMA INT		
		int a = Integer.valueOf(request.getParameter("a"));
		int b = Integer.valueOf(request.getParameter("b"));		
		// TODO Auto-generated method stub
		response.getWriter().append(String.valueOf(a+b));
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Passei no POST! - " + new java.util.Date());
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
