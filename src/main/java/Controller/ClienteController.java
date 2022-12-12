package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Cliente;
import Model.ClienteDao;
import Util.Conexao;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(urlPatterns={"/ClienteController","/novocliente","/buscacliente","/selecionado","/editar","/excluir"})

public class ClienteController extends HttpServlet {
	
	Cliente cli = new Cliente();
	
	Conexao conexao = new Conexao();
	
	ClienteDao dao = new ClienteDao();
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ClienteController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//conexao.Testarconexao();
		
		
		String action = request.getServletPath();
		
		if(action.equals("/novocliente")) {
			BuscaDados(request,response);
		}
		else if(action.equals("/buscacliente")) {
			ListaDados(request,response);
		}else if(action.equals("/selecionado")) {
			mostrar(request,response);
		}else if(action.equals("/editar")) {
			EditarCli(request,response);
		}else if(action.equals("/excluir")) {
			ExcluirCli(request,response);
		}
				
		
	}
	
	
	protected void BuscaDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		cli.setIdCliente(Integer.parseInt(request.getParameter("idcliente")));
		cli.setNome(request.getParameter("nome"));
		cli.setTelefone(request.getParameter("telefone"));
		
		//System.out.println(cli.getIdCliente()+cli.getNome()+cli.getTelefone());
		
		dao.Salvar(cli);
	}
	
	
	protected void ListaDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		ArrayList<Cliente> lista = dao.listar();
		request.setAttribute("clientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("FrLista.jsp");
		rd.forward(request, response);      
		
		
	}
	
	protected void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idcliente = Integer.parseInt(request.getParameter("idcliente"));
		cli.setIdCliente(idcliente);		
		dao.BuscaCli(cli);
		
		request.setAttribute("idcliente", cli.getIdCliente());
		request.setAttribute("nome", cli.getNome());
		request.setAttribute("telefone", cli.getTelefone());
		
		RequestDispatcher rd = request.getRequestDispatcher("FrEditar.jsp");
		rd.forward(request, response);
		
	}
	
	protected void EditarCli(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idcliente = Integer.parseInt(request.getParameter("idcliente"));
		cli.setIdCliente(idcliente);
		cli.setNome(request.getParameter("nome"));
		cli.setTelefone(request.getParameter("telefone"));
		
		dao.Editar(cli);
		response.sendRedirect("principal.jsp");
		
	}
	
	protected void ExcluirCli(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idcliente = Integer.parseInt(request.getParameter("idcliente"));
		cli.setIdCliente(idcliente);
		 dao.Excluir(cli);
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
