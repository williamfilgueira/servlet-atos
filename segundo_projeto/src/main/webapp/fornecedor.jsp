<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Fornecedor"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Fornecedor> lista = (ArrayList<Fornecedor>) request.getAttribute("fornecedor");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="global.css">
<link rel="stylesheet" href="dashboard.css">
<link rel="stylesheet" href="clientes.css">
<title>Fornecedor</title>
</head>
<body>
	<header id="header">
		<div class="container-header">
			<div class="logo">
				<img alt="logo dashboard" src="assets/dashboard.png">
			</div>
			<div class="menu">

				<div class="box-menu">
					<input type="checkbox" id="checkbox-menu"> <label
						for="checkbox-menu"> <span></span> <span></span> <span></span>
					</label>
					<nav>
						<ul>
							<li><a href="clientes">Clientes</a></li>
							<li><a href="fornecedor">Fornecedores</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>

	</header>
<body>

	<div class="container-clientes">
		<div class="box-table">
			<div class="botao-add">
				<a href="novoFornecedor"> <img alt="adicionar novo cliente"
					src="assets/user-plus.png">
				</a>
			</div>
			<table id="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>CNPJ</th>
						<th>Telefone</th>
						<th>Email</th>
						<th>Opções</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < lista.size(); i++) {
					%>
					<tr>
						<td><%=lista.get(i).getId()%></td>
						<td><%=lista.get(i).getNome()%></td>
						<td><%=lista.get(i).getCnpj()%></td>
						<td><%=lista.get(i).getFone()%></td>
						<td><%=lista.get(i).getEmail()%></td>
						<td>
							<div class="box-icon">
								<div class="icon">
									<a href="" class="icon"><img alt="novo cliente"
										src="./assets/bim.png"> </a>
								</div>
								<div class="icon">
									<a href=" " class="icon"><img alt="novo contato"
										src="./assets/document-edit.png"></a>
								</div>
							</div>
						</td>

					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>