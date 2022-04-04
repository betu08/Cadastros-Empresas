package br.com.alura.gerenciado.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciado.modelo.Banco;
import br.com.alura.gerenciado.modelo.Empresa;

public class NovaFormEmpresa implements Acao{
	
	public String executa (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		return "forward:formNovaEmpresa.jsp";

	}
	

}
