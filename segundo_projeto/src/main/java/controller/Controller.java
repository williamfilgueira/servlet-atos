package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionJDBC;
import model.Cliente;
import model.Endereco;
import model.Fornecedor;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/dashboard", "/clientes", "/novoCliente", "/fornecedor", "/novoFornecedor",
		"/insert", "/insertFornecedor", "/select", "/update" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ConnectionJDBC dao = new ConnectionJDBC();
	Cliente cliente = new Cliente();
	Fornecedor fornecedor = new Fornecedor();
	Endereco endereco = new Endereco();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao.testeConexão();
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/dashboard")) {
			response.sendRedirect("dashboard.jsp");
		} else if (action.equals("/produtos")) {
			response.sendRedirect("produtos.jsp");
		} else if (action.equals("/produtos")) {
			response.sendRedirect("produtos.jsp");
		} else if (action.equals("/insert")) {
			newClient(request, response);
		} else if (action.equals("/select")) {
			listarClientes(request, response);
		} else if (action.equals("/update")) {
			editarCliente(request, response);
		} else if (action.equals("/insertFornecedor")) {
			novoFornecedor(request, response);
		} else if (action.equals("/clientes")) {
			clientes(request, response);
		} else if (action.equals("/novoCliente")) {
			response.sendRedirect("novoCliente.html");
		} else if (action.equals("/fornecedor")) {
			fornecedor(request, response);
//			response.sendRedirect("fornecedor.jsp");
		} else if (action.equals("/novoFornecedor")) {
			response.sendRedirect("novoFornecedor.html");
		} else {
			response.sendRedirect("/dashboard.jsp");
		}
	}

	protected void clientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Cliente> lista = dao.listarClientes();
		for (int i = 0; i < lista.size(); i++) {
//			System.out.println(lista.get(i).getId());
//			System.out.println(lista.get(i).getNome());
//			System.out.println(lista.get(i).getCpf());
//			System.out.println(lista.get(i).getFone());
//			System.out.println(lista.get(i).getEmail());
		}

		request.setAttribute("clientes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("clientes.jsp");
		rd.forward(request, response);
	}

	protected void listarClientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
//		System.out.println(id);
		cliente.setId(id);
		dao.selecionarCliente(cliente);

		request.setAttribute("id", cliente.getId());
		request.setAttribute("nome", cliente.getNome());
		request.setAttribute("cpf", cliente.getCpf());
		request.setAttribute("fone", cliente.getFone());
		request.setAttribute("email", cliente.getEmail());

		RequestDispatcher rd = request.getRequestDispatcher("editarCliente.jsp");
		rd.forward(request, response);
//		System.out.println(cliente.getId());
//		System.out.println(cliente.getNome());
//		System.out.println(cliente.getCpf());
//		System.out.println(cliente.getFone());
//		System.out.println(cliente.getEmail());

	}

	protected void newClient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		teste de recebimento da informações vindas do formulario
//		System.out.println(request.getParameter("nome"));
//		System.out.println(request.getParameter("cpf"));
//		System.out.println(request.getParameter("fone"));
//		System.out.println(request.getParameter("email"));
//
//		System.out.println(request.getParameter("cep"));
//		System.out.println(request.getParameter("rua"));
//		System.out.println(request.getParameter("numero"));
//		System.out.println(request.getParameter("complemento"));

		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setFone(request.getParameter("fone"));
		cliente.setEmail(request.getParameter("email"));

		endereco.setCep(Integer.parseInt(request.getParameter("cep")));
		endereco.setRua(request.getParameter("rua"));
		endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
		endereco.setComplemento(request.getParameter("complemento"));

		dao.newClient(cliente, endereco);
		response.sendRedirect("clientes");
	}

	protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("nome"));
//		System.out.println(request.getParameter("cpf"));
//		System.out.println(request.getParameter("fone"));
//		System.out.println(request.getParameter("mail"));
		
		cliente.setId(request.getParameter("id"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setFone(request.getParameter("fone"));
		cliente.setEmail(request.getParameter("email"));
		
		
		
	}

	protected void fornecedor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Fornecedor> lista = dao.listarFornecedores();
		for (int i = 0; i < lista.size(); i++) {
//			System.out.println(lista.get(i).getId());
//			System.out.println(lista.get(i).getNome());
//			System.out.println(lista.get(i).getCnpj());
//			System.out.println(lista.get(i).getFone());
//			System.out.println(lista.get(i).getEmail());
		}

		request.setAttribute("fornecedor", lista);
		RequestDispatcher rd = request.getRequestDispatcher("fornecedor.jsp");
		rd.forward(request, response);
	}

	protected void listarFornecedores(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void novoFornecedor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		teste de recebimento da informações vindas do formulario
//		System.out.println(request.getParameter("nome"));
//		System.out.println(request.getParameter("cpnj"));
//		System.out.println(request.getParameter("fone"));
//		System.out.println(request.getParameter("email"));

		fornecedor.setNome(request.getParameter("nome"));
		fornecedor.setCnpj(request.getParameter("cnpj"));
		fornecedor.setFone(request.getParameter("fone"));
		fornecedor.setEmail(request.getParameter("email"));

		endereco.setCep(Integer.parseInt(request.getParameter("cep")));
		endereco.setRua(request.getParameter("rua"));
		endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
		endereco.setComplemento(request.getParameter("complemento"));

		dao.novoFornecedor(fornecedor, endereco);
		response.sendRedirect("fornecedor");
	}
}
