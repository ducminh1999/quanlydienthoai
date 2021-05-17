<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
</head>
<body>
	<jsp:include page="_menu.jsp"></jsp:include>
	<div class="container tm-mt-big tm-mb-big">
		<div class="row">
			<div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
				<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
					<div class="row" style="text-align: center">
						<div class="col-12">
							<h2 style="color: white">Sửa sản phẩm</h2>
						</div>
						<div class="col-12" style="height: 30px;">
							<div style="color: yellow;text-align: center;">${errorString}</div>
						</div>
					</div>
					<div class="row tm-edit-product-row">
						<div class="col-xl-6 col-lg-6 col-md-12" style="margin: auto;">
							<c:if test="${not empty product}">
								<form action="${pageContext.request.contextPath}/editProduct"
									method="post" class="tm-edit-product-form">
									<div class="form-group mb-3">
										<label for="name">Code </label> <input id="code" name="code"
											type="text" class="form-control"
											value="${product.code}" maxlength="4" readonly style="background: #54657d"/>
									</div>
									<div class="form-group mb-3">
										<label for="description">Product Name</label> <input id="name"
											name="name" type="text" class="form-control"
											value="${product.name}" maxlength="40" required/>
									</div>
									<div class="form-group mb-3">
										<label for="description">Price</label> <input id="price"
											name="price" type="text" class="form-control"
											value="${product.price}" maxlength="10" required/>
									</div>

									<div>
										<input type="submit" value="Thay đổi"
											class="btn btn-primary btn-block text-uppercase"/> <input
											type="button" value="Hủy"
											class="btn btn-primary btn-block text-uppercase"
											onclick="window.location.href='${pageContext.request.contextPath}/productList'">
									</div>
								</form>
							</c:if>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>