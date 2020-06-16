package ftt.ec.api;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//TODO:
// Ler arquivo no init()
//Criar arrayList no init() e carregar dados do arquivo
//Salvar dados no ArrayList no arquivo no destroy()
//Implementar os verbos HTTP para controlar a lista de dados

/**
 * Servlet implementation class ListApi
 */
@WebServlet("/ListApi")
public class ListApi extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private HashMap<String, String> userData;
    
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		//Ler arquivo no init()
		//Criar arrayList no init() e carregar dados do arquivo
		
		this.userData = new HashMap<String, String>(); //ID, Name
		
		
		/*
		try{

            FileReader fr = new FileReader("doc.txt");
            BufferedReader br = new BufferedReader(fr);

            String str;
            while((str = br.readLine()) != null){
                out.println(str + "\n");
            } 

        }
        catch(IOException e){
        out.println("Arquivo não encontrado!");}
    	}*/
		
		BufferedReader br;
		List<String[]> lista = new ArrayList<>();    
	    try {
	            br = new BufferedReader(new FileReader("doc.txt"));

	            String str;
	            while((str = br.readLine()) != null){
	                lista.add(str.split(";"));
	            } 
	            br.close(); 

	     } catch(IOException e) {
	    	 System.out.println("Arquivo não encontrado!");
	     }/* finally {  
	    	 br.close(); 
	     }*/
	     lista.forEach(a -> System.out.println(Arrays.toString(a)));
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		 // TODO Auto-generated method stub
		
		 //Salvar dados no ArrayList no arquivo no destroy()
		 
		
		
		/*
		try {
	     //Cria o arquivo
	     FileOutputStream file = new FileOutputStream("doc.txt");
	     //Cria o objeto para arquivo
		 ObjectOutputStream esc = new ObjectOutputStream(file);

	     //Fecha o objeto
		 esc.close();
		 } catch(IOException e) {
	    	 System.out.println("Arquivo não encontrado!");
	     }*/
		
	}

	//Implementar os verbos HTTP para controlar a lista de dados
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		
		if (id == null)
			response.getWriter().append(this.userData.toString());
		else {
			try {
				response.getWriter().append(this.userData.get(id).toString());
			} catch (Exception e){
				response.getWriter().append("Error: " + id + " not found");
			}
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		response.getWriter().append(this.userData.put(id, name));
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		
		if(id != null) {
			this.userData.remove(id);
			response.getWriter().append("Deletado");           
		} else 
			response.getWriter().append("Informe um id");
		
	}

}
