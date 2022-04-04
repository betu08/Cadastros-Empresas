package br.com.alura.gerenciado.servlet;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciado.acao.Acao;
import br.com.alura.gerenciado.acao.AlteraEmpresa;
import br.com.alura.gerenciado.acao.ListaEmpresas;
import br.com.alura.gerenciado.acao.MostraEmpresa;
import br.com.alura.gerenciado.acao.NovaEmpresa;
import br.com.alura.gerenciado.acao.NovaFormEmpresa;
import br.com.alura.gerenciado.acao.RemoveEmpresa;
import br.com.alura.gerenciado.modelo.Banco;
import br.com.alura.gerenciado.modelo.Empresa;


@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String paramAcao = request.getParameter("acao");
		
	//	HttpSession sessao = request.getSession();
	//	boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuariologado") == null);
	//	boolean eHUmaAcaoNaoProtegida = ! (paramAcao.equals("Login") || paramAcao.equals("FormLogin"));
		
	//	if(eHUmaAcaoNaoProtegida && usuarioNaoEstaLogado) {
	//		response.sendRedirect ("entrada?acao=FormLogin");
	//		return;
		//}
		
		

		String NomeDaClasse = "br.com.alura.gerenciado.acao." + paramAcao;
		
		String nome; 

		try {
			Class classe = Class.forName(NomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		

		String[] tipoEndereco = nome.split(":");
		
		if(tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/" + tipoEndereco[1]);
			rd.forward(request, response);
		}else response.sendRedirect(tipoEndereco[1]);
		
	}
		
//		String paramAcao = request.getParameter("acao");
//		
//		String nome = null;
//		
//		
//		if(paramAcao.equals("listaempresa")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request,response);
//			
//		}else if(paramAcao.equals("removeempresa")) {
//
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);
//
//		}else if(paramAcao.equals("mostraempresa")) {
//
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);
//			
//		}else if(paramAcao.equals("alteraempresa")) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//			
//		}else if(paramAcao.equals("novaempresa")) {
//				NovaEmpresa acao = new NovaEmpresa();
//				nome = acao.executa(request, response);
//		}else if(paramAcao.equals("NovaempresaForm")) {
//				NovaFormEmpresa acao = new NovaFormEmpresa();
//				nome = acao.executa(request, response);
//				}
		

		


}


	
