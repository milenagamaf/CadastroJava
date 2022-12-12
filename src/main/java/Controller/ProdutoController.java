package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.Produto;
import Model.ProdutoDao;
import Util.Conexao;

/**
 * Servlet implementation class ProdutoController
 */
@WebServlet(urlPatterns = {"/ProdutoController","/novoproduto","/buscaproduto","/selecionarproduto","/editarproduto","/excluirproduto"})
public class ProdutoController extends HttpServlet {
	
	Produto pro = new Produto();
	
	Conexao cone = new Conexao();
	
	ProdutoDao dao = new ProdutoDao();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
     //cone.Testarconexao();
		
		String action = request.getServletPath();
		
		if(action.equals("/novoproduto")) {
			BuscaDados(request,response);
		}else if(action.equals("/buscaproduto")) {
			ListaDados(request,response);
		}else if(action.equals("/selecionarproduto")) {
			mostrarpro(request,response);
		}else if(action.equals("/editarproduto")) {
			EditarPro(request,response);
		}else if(action.equals("/excluirproduto")) {
			ExcluirPro(request,response);
		}

	}
	
	protected void BuscaDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		pro.setIdProduto(Integer.parseInt(request.getParameter("idproduto")));
		pro.setNome(request.getParameter("nome"));
		pro.setPreco(Double.parseDouble(request.getParameter("preco")));
		pro.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		
		System.out.println(pro.getIdProduto()+pro.getNome()+pro.getPreco()+pro.getQuantidade());
		
	   dao.Salvar(pro);
		
		
	}
	
	protected void ListaDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                   ArrayList<Produto> lista = dao.listar(); 
	               request.setAttribute("produtos", lista);   
	               RequestDispatcher rd = request.getRequestDispatcher("Lista.jsp");
	               rd.forward(request, response);
	
	}
	
	protected void mostrarpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idproduto = Integer.parseInt(request.getParameter("idproduto"));
		pro.setIdProduto(idproduto);
		dao.BuscaPro(pro);
		
		request.setAttribute("idproduto", pro.getIdProduto());
		request.setAttribute("nome", pro.getNome());
		request.setAttribute("preco", pro.getPreco());
		request.setAttribute("quantidade", pro.getQuantidade());
		
		RequestDispatcher rd = request.getRequestDispatcher("Editar.jsp");
		rd.forward(request, response);
		
	}
	
	protected void EditarPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idproduto = Integer.parseInt(request.getParameter("idproduto"));
		Double preco = Double.parseDouble(request.getParameter("preco"));
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		
		pro.setIdProduto(idproduto);
		pro.setNome(request.getParameter("nome"));
		pro.setPreco(preco);
		pro.setQuantidade(quantidade);
		
		dao.Editar(pro);
		response.sendRedirect("principal.jsp");
		
	}
	
	protected void ExcluirPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idproduto = Integer.parseInt(request.getParameter("idproduto"));
		pro.setIdProduto(idproduto);
		 dao.Excluir(pro);
		 response.sendRedirect("principal.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
