<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>
</head>
<jsp:include page="_menu.jsp"></jsp:include>
<div class="container mt-5">
	<div class="col-sm-12 col-md-12 col-lg-8 col-xl-8 tm-block-col"
		style="margin: auto">
		<div class="tm-bg-primary-dark tm-block tm-block-h-auto" style="resize:both; overflow:auto; max-height: fit-content; min-height: 300px">
			<div class="row" style="text-align: center">
				<div class="col-12">
					<h1 class="tm-block-title d-inline-block" style="font-size: 30px">Thông
						tin tài khoản</h1>
				</div>
				<div class="col-12">
					<p style="color: yellow;">${errorString}</p>
				</div>
			</div>
			<div class="row tm-edit-product-row">
				<div class="col-xl-6 col-lg-6 col-md-12"
					style="margin: auto; font-size: 20px; ">
					<p>
						<b>Tên tài khoản: ${user.userName}</b>
					</p>
					<b>Giới tính: ${user.gender}</b>
				</div>
			</div>

		</div>
	</div>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>