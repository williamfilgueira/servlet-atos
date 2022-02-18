<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-bt">
<head>
<meta charset="utf-8">
<link rel="icon" href="">
<link rel="stylesheet" href="global.css">
<link rel="stylesheet" href="dashboard.css">
<title>Dashboard</title>
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
	<main>
		<div class="container-main">
			<div class="box-main">
				<div class="card">
					<div class="title-card"></div>
					<a class="link-card" href="produtos">
						<div class="content-card">Produtos</div>
					</a>
				</div>
				<div class="card">
					<div class="title-card"></div>
					<a class="link-card" href="clientes">
						<div class="content-card">Clientes</div>
					</a>
				</div>
				<div class="card">
					<div class="title-card"></div>
					<a class="link-card" href="fornecedor">
						<div class="content-card">Fornecedores</div>
					</a>
				</div>
			</div>
		</div>
	</main>


</body>
</html>