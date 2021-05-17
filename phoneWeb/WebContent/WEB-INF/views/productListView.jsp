<%@page import="model.bean.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<jsp:include page="_menu.jsp"></jsp:include>
<div class="container mt-5">
	<div class="col-sm-12 col-md-12 col-lg-8 col-xl-8 tm-block-col"
		style="margin: auto">
		<div class="tm-bg-primary-dark tm-block tm-block-products" style="resize:both; overflow:auto; max-height: fit-content;">
			<h4 style="color: white;">Danh sách sản phẩm</h4>
			<form method="POST"
				action="${pageContext.request.contextPath}/searchProduct">
				<div>
					<input type="text" name="search" placeholder="Nhập tên sản phẩm" />
					<input type="submit" value="Tìm kiếm"
						style="background-color: #feb624; width: 80px;" />
				</div>
			</form>
			<div style="height: 24px; margin:8px 0">
				<div style="color: #00ff43;">${mes}</div>
				<div style="color: yellow; ">${errorString}</div>
			</div>
			<div class="tm-product-table-container" style="resize:both; overflow:auto; max-height: 360px; padding-top: -10px">
				<table class="table table-hover tm-table-small tm-product-table">
					<thead>
						<tr>
							<th scope="col">Code</th>
							<!-- <th scope="col">Code</th> -->
							<th scope="col">Product name</th>
							<th scope="col">Price</th>
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productList}" var="product" varStatus="loop">
							<tr>
								<%-- <td>${loop.index+1}</td> --%>
								<td>${product.code}</td>
								<td>${product.name}</td>
								<td>${product.price}$</td>
								<td><a href="editProduct?code=${product.code}"
									class="tm-product-delete-link"><i class="far fa-edit tm-product-delete-icon"></i></a></td>
								<td><a href="#" class="tm-product-delete-link" data-href="" 
								 	data-toggle="modal" data-target="#confirm-delete${product.code}">
								 	<i class="far fa-trash-alt tm-product-delete-icon"></i></a></td>
							</tr>
							<!--Console xác nhận xóa-->
							<div class="modal fade" id="confirm-delete${product.code}" tabindex="-1" role="dialog" 
								aria-labelledby="myModalLabel" aria-hidden="true">
							    <div class="modal-dialog">
							        <div class="modal-content">
							            <div class="modal-header" style="font-size: 20px">
							                Bạn sẽ không thể khôi phục lại.
							            </div>
							            <div class="modal-body" style="color: red">
							                Bạn có thực sự muốn xóa "${product.name}"?
							            </div>
							            <div class="modal-footer">
							                <button type="button" class="btn" data-dismiss="modal" style="background-color: #09aaef; color:white">Cancel</button>
							            <form method="POST" action="${pageContext.request.contextPath}/deleteProduct?code=${product.code}">
							                <button type="submit" class="btn btn-danger btn-ok">Delete</button>
							            </form>
							            </div>
							        </div>
							    </div>
							</div>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- table container -->
			<a href="${pageContext.request.contextPath}/addProduct"
				class="btn btn-primary btn-block text-uppercase mb-3">Thêm sản
				phẩm</a>
		</div>
	</div>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>