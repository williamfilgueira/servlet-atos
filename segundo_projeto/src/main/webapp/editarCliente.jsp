<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="global.css">
<link rel="stylesheet" href="dashboard.css">
<link rel="stylesheet" href="clientes.css">
<title>Cliente</title>
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
		<div class="box-new-client">
			<div class="title-form"></div>
			<form name="frmCliente" action="update">
				<div class="content-form">
					<h3>Criar novo cliente</h3>
					<input type="text" name="id" placeholder="ID" readonly
						value="<%out.println(request.getAttribute("id"));%>"> <input
						type="text" name="nome" placeholder="Nome"
						value="<%out.println(request.getAttribute("nome"));%>"> <input
						type="text" name="cpf" placeholder="CPF"
						value="<%out.println(request.getAttribute("cpf"));%>"> <input
						type="text" name="fone" placeholder="Telefone"
						value="<%out.println(request.getAttribute("fone"));%>"> <input
						type="text" name="email" placeholder="E-mail"
						value="<%out.println(request.getAttribute("email"));%>">
					<h3>Endereço</h3>
					<input type="number" name="cep" placeholder="CEP"> <input
						type="text" name="rua" placeholder="Rua"> <input
						type="number" name="numero" placeholder="N°"> <input
						type="text" name="complemento" placeholder="Complemento">
				</div>
				<input type="button" value="Criar" onClick="validar()">
			</form>
		</div>
	</div>
	<script src="scripts/validador.js"></script>
</body>
</html>