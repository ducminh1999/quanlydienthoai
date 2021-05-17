<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
	<jsp:include page="_menu.jsp"></jsp:include>
	<div class="container tm-mt-big tm-mb-big">
		<div class="row">
			<div class="col-12 mx-auto tm-login-col">
				<div class="tm-bg-primary-dark tm-block tm-block-h-auto">
						<div class="col-12 text-center tm-block-title">
							<h2 class="">Đăng nhập</h2>
						</div>
					<p style="color: yellow; text-align: center;">${errorString}</p>
					<div class="row mt-2">
						<div class="col-12">
							<form action="${pageContext.request.contextPath}/login" method="post" class="tm-login-form">
								<div class="form-group">
									<label for="username">User Name</label> <input name="userName"
										type="text" class="form-control validate" id="username"
										value="${user.userName}" required />
								</div>
								<div class="form-group mt-3">
									<label for="password">Password</label> <input name="password"
										type="password" class="form-control" id="password"
										value="${user.password}" required />
								</div>
								<div class="form-group">
									<input type="checkbox" name="rememberMe" value= "Y" 
										style="background-color: #f5a623;margin-bottom: -5px"/> 
									<label>Nhớ tài khoản</label> 
								</div>
								<div class="form-group mt-4">
									<button type="submit"
										class="btn btn-primary btn-block text-uppercase">
										Đăng nhập</button>
								</div>
							</form>
						</div>
					</div>
					<div><p style="color: white; ">User Name: minh,
						password: 123 hoặc manh/123</p></div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>