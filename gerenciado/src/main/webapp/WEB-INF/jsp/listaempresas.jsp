<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ page import="java.util.List,br.com.alura.gerenciado.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Empresas</title>
</head>
<body>

		<c:import url="logout-parcial.jsp" />
		
		Usuario Logado: ${usuariologado.login }
		
		<br>
		<br>
		<br>
		
		<c:if test="${not empty empresa }">
		Empresa ${ empresa } cadastrada com sucesso!
		</c:if>
	

	Lista de Empresas:

			<ul>
				<c:forEach items= "${empresas}" var="empresa" >
				<li>
					${empresa.nome} <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/> 
					<a href="/gerenciado/entrada?acao=MostraEmpresa&id=${empresa.id}">Editar empresa</a>
					<a href="/gerenciado/entrada?acao=RemoveEmpresa&id=${empresa.id}">Remover</a>
				
				</li>
				</c:forEach>
			</ul>
</body>
</html>