package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.MyDAO;
import model.DAO.MyUtils;
import model.bean.Product;
import model.bean.UserAccount;

@WebServlet(urlPatterns = {"/addProduct" })
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int codenew = 0;

	public CreateProductServlet() {
		super();
	}

	// Hiển thị trang tạo sản phẩm.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserAccount loginedUser = MyUtils.getLoginedUser(session);
		Connection conn = MyUtils.getStoredConnection(request);
		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			List<Product> list = null;
			try {
				list = MyDAO.queryProduct(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for (Product product : list) {
				if(codenew==product.getCode())
					codenew++;
			}
			request.setAttribute("user", loginedUser);
			request.setAttribute("code", codenew);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorString = null;
		Connection conn = MyUtils.getStoredConnection(request);
		HttpSession session = request.getSession();
		int code = Integer.parseInt(request.getParameter("code"));
		String name = (String) request.getParameter("name").trim();
		String priceStr = (String) request.getParameter("price");
		float price = 0;
		if (name == "")
			errorString = "Bạn cần nhập tên sản phẩm";
		try {
			price = Float.parseFloat(priceStr);
		} catch (Exception e) {
			errorString = "Price cần nhập một số thực";
		}
		if (priceStr == "")
			errorString = "Bạn cần nhập vào Price";
		
		Product product = new Product(code, name, price);
		
		// Lưu thông tin vào request attribute trước khi forward sang views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("code", codenew);
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
			dispatcher.forward(request, response);
		} else {
			try {
				MyDAO.insertProduct(conn, product);
				session.setAttribute("add", "Đã thêm '"+product.getName()+"' thành công");
			} catch (SQLException e) {
				errorString = "Mã code = "+code+" đã tồn tại.";
				request.setAttribute("errorString", errorString);
			}
			response.sendRedirect("/productList");
		}
	}
}
