package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String paramId = request.getParameter("id");//ler parametro
		Integer id = Integer.valueOf(paramId); // converte parametro

		
		Banco banco = new Banco();

		Empresa empresa = banco.buscaEmpresaPelaId(id);// busca informação no banc de dados
		
		System.out.println(empresa.getNome());
		
		request.setAttribute("empresa", empresa);//leva a informação
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		
		rd.forward(request, response);
	}

}
