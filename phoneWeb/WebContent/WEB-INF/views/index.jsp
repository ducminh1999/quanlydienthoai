<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<jsp:include page="_menu.jsp"></jsp:include>
<div class="container mt-5">
	<div class="col-sm-12 col-md-12 col-lg-8 col-xl-8 tm-block-col" style="margin: auto">
		<div class="tm-bg-primary-dark tm-block tm-block-products" style="resize:both; overflow:auto; max-height: fit-content;">
			<div class="row" style="margin-top: -30px">
				<div class="col">
					<h5 class="text-white mt-5 mb-5">
						Xin chào <b>${loginedUser.userName}</b>
					</h5>
				</div>
			</div>
			<!-- row -->
			<div class="row tm-content-row">
				<div class="text-white" style="margin:0 40px;">
					<p>Đây là trang một trang web quản lý sản phẩm đơn giản sử dụng jsp, servlet, Jdbc</p>
					<b>Trang web bao gồm các chức năng:</b>
					<ul>
						<p>
						<li>Đăng nhập (Chọn "Đăng nhập" phía bên phải phía trên màn hình, 
							sử dụng thông tin tài khoản bên dưới màn hình đăng nhập để đăng nhập)</li>
						</p>
						<p>
						<li>Đăng xuất tài khoản (Chọn "Đăng xuất" phía bên phải phía trên màn hình)</li>
						</p>
						<p>
						<li>Sử dụng Session, Cookie để lưu phiên làm việc</li>
						</p>
						<p>
						<li>Xem thông tin tài khoản</li>
							<ul>
							<li>Yêu cầu đăng nhập để sử dụng chức năng</li>
							<li>Sau khi đăng nhập chọn mục "Tài khoản cá nhân"</li>
							</ul>
						</p>
						
						<p>
						<li>Xem danh sách sản phẩm</li>
						<ul>
							<li>Yêu cầu đăng nhập để sử dụng chức năng</li>
							<li>Sau khi đăng nhập chọn mục "Danh sách sản phẩm"</li>
							</ul>
						</p>
						<p>
						<li>Tìm kiếm sản phẩm theo tên</li>
						<ul>
							<li>Yêu cầu đăng nhập để sử dụng chức năng</li>
							<li>Sau khi đăng nhập chọn mục "Danh sách sản phẩm"</li>
							<li>Nhập tên sản phẩm cần tìm vào ô "Nhập tên sản phẩm"</li>
							<li>Nhấn Enter hoặc click vào "Tìm kiếm"</li>
							</ul>
						</p>
						<p>
						<li>Thêm sản phẩm</li>
						<ul>
							<li>Yêu cầu đăng nhập để sử dụng chức năng</li>
							<li>Sau khi đăng nhập chọn mục "Danh sách sản phẩm"</li>
							<li>Chọn "Thêm sản phẩm"</li>
							<li>Nhập thông tin vào form rồi chọn "Thêm". Nếu muốn hủy thì chọn "Hủy".</li>
							</ul>
						</p>
						<p>
						<li>Chỉnh sửa sản phẩm</li>
						<ul>
							<li>Yêu cầu đăng nhập để sử dụng chức năng</li>
							<li>Sau khi đăng nhập chọn mục "Danh sách sản phẩm"</li>
							<li>Chọn sản phẩm cần chỉnh sửa rồi nhấn vào biểu tượng chỉnh sửa trong cột Edit.</li>
							<li>Nhập thông tin cần chỉnh sửa vào form rồi chọn "Thay đổi". Nếu muốn hủy thì chọn "Hủy".</li>
							</ul>
						</p>
						<p>
						<li>Xóa sản phẩm</li>
						<ul>
							<li>Yêu cầu đăng nhập để sử dụng chức năng</li>
							<li>Sau khi đăng nhập chọn mục "Danh sách sản phẩm"</li>
							<li>Chọn sản phẩm cần xóa rồi nhấn vào biểu tượng thùng rác trong cột Delete.</li>
							</ul>
						</p>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>