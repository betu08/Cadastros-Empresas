package br.com.alura.gerenciado.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciado.modelo.Banco;
import br.com.alura.gerenciado.modelo.Empresa;

public class MostraEmpresa implements Acao {
	
	public String executa (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Motrando empresas");
		
		String paramid = request.getParameter("id");
		Integer id = Integer.valueOf(paramid);	
		
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresaPelaid(id);
		
		System.out.println(empresa.getNome());
		
		request.setAttribute("empresa", empresa);
		
		return "forward:formAlteraEmpresa.jsp";

		
		
		
		
	}
	

}
