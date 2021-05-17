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
    <title>Trang chủ</title>
    <link rel="stylesheet" href="./css/fonts.css" />
    <!-- https://fonts.google.com/specimen/Open+Sans -->
    <link rel="stylesheet" href="./css/fontawesome.min.css" />
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="./css/bootstrap.min.css" />
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="./css/templatemo-style.css">
    <!-- https://templatemo.com/tm-524-product-admin -->
</head>
<body>
<div class="header">
	<div style="float: left">
		<h1>Quản lý sản phẩm</h1>
	</div>
	<div style="float: right; padding: 20px; text-align: right;">
		<%
			session = request.getSession();
		UserAccount user = (UserAccount) session.getAttribute("loginedUser");
		%>
		<%
			if (user != null) {
		%>
		<b>Xin chào</b> <b style="color: #1bff00; font-size: 20px">${loginedUser.userName}</b>
		<%
			}
		%>
	</div>
</div>

</body>