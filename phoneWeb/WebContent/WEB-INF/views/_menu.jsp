<%@page import="model.bean.UserAccount"%>
<%@page import="org.apache.catalina.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Quản lý điện thoại</title>
    <link rel="stylesheet" href=".\static\css\fonts.css">
    <!-- https://fonts.google.com/specimen/Roboto -->
    <link rel="stylesheet" href=".\static\css\fontawesome.min.css">
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href=".\static\css\bootstrap.min.css">
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href=".\static\css\templatemo-style.css"> 
</head>
<body>
	<div>
		<%
			session = request.getSession();
			UserAccount user=null;
			user = (UserAccount) session.getAttribute("loginedUser");
		%>
		<nav class="navbar navbar-expand-xl">
			<div class="container h-100">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/">
					<h1 class="tm-site-title mb-0">Quản lý điện thoại</h1>
				</a>
				<button class="navbar-toggler ml-auto mr-0" type="button"
					data-toggle="collapse" data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="fas fa-bars tm-nav-icon"></i>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent" style="font-size: 20px">
					<%
						if (user == null) {
					%>
					<ul class="navbar-nav mx-auto h-100">
						<li class="nav-item" style="margin-left: -70px"><a class="nav-link" href="${pageContext.request.contextPath}/" id="t1" onclick="home()">
								<i class="fas fa-home"></i> Trang chủ <span
								class="sr-only">(current)</span>
						</a></li>
					</ul>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link d-block"
							href="${pageContext.request.contextPath}/login"><b>Đăng nhập</b>
						</a></li>
					</ul>
					<% } else { %>
				
					<ul class="navbar-nav mx-auto h-100">
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/" id="t1" onclick="home()">
								<i class="fas fa-home"></i> Trang chủ <span
								class="sr-only">(current)</span>
						</a></li>
						
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/productList" id="t2" onclick="list()">
								<i class="fas fa-list"></i> Danh sách sản phẩm
						</a></li>

						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/userInfo" id="t3" onclick="account()">
								<i class="far fa-user"></i> Tài khoản cá nhân
						</a></li>
					</ul>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link d-block"
							href="${pageContext.request.contextPath}/logout"> ${loginedUser.userName.toString()}  <b>Đăng xuất</b>
						</a></li>
					</ul>
					<% } %>
				</div>
			</div>
		</nav>
	</div>
	
