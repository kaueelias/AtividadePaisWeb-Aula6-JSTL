/**
 * As coisas começam no index, que chama o método post ou o método get.
 * Fica aqui:
 * O minimo para extrair o request, instância o objeto, no caso o pais
 * não pode ter regra de negócio, n pode comunicar c o banco, tem que ser o mais simples possível.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

/**
 * Servlet implementation class ManterPaisController
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nomePais");
		long pPopulacao = Long.parseLong(request.getParameter("populacaoPais"));
		double pArea = Double.parseDouble(request.getParameter("areaPais"));
		
		//instanciar o javabean
		Pais pais = new Pais(pNome, pPopulacao, pArea);
		
		//instanciar o service
		PaisService cs = new PaisService();
		int id = cs.criar(pais);
		pais = cs.carregar(id);
		
		/**PrintWriter out = response.getWriter();
		out.println("<html><head><title>Pais Cadastrado</title></head><body>");
		out.println(	"Id: "+pais.getId()+"<br>");
		out.println(	"Nome: "+pais.getNome()+"<br>");
		out.println(	"População: "+pais.getPopulacao()+"<br>");
		out.println(	"Área: "+pais.getArea()+"<br>");
	    out.println("</body></html>");**/
		
		//enviarpara o jsp
		request.setAttribute("Pais", pais);

		RequestDispatcher view = request.getRequestDispatcher("PaisJSP.jsp");
		view.forward(request, response);
		
	}

}