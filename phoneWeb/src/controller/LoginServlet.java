package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.MyDAO;
import model.DAO.MyUtils;
import model.bean.UserAccount;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserAccount loginedUser = MyUtils.getLoginedUser(session);
		// Neu da dang nhap
		if (loginedUser != null) {
			RequestDispatcher dispatcher
					= this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher
					= this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
			dispatcher.forward(request, response);
		}

	}

	// Khi nguoi nhap userName & password, và nhấn Submit.
	// Phương thức này sẽ được thực thi.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String rememberMeStr = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMeStr);

		UserAccount user = null;
		boolean hasError = false;
		String errorString = null;

		if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
			hasError = true;
			errorString = "Bạn cần nhập User Name và Password!";
		} else {
			Connection conn = MyUtils.getStoredConnection(request);
			try {
				// Tìm user trong DB.
				user = MyDAO.findUser(conn, userName, password);
				if (user == null) {
					hasError = true;
					errorString = "User Name hoặc password không tồn tại";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}
		if (hasError) {
			user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);

			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);

			RequestDispatcher dispatcher //
					= this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");

			dispatcher.forward(request, response);
		}
		// Truong hợp không có lỗi.
		// Lưu thông tin nguoi dùng vào Session.
		// Và chuyển hướng sang trang userInfo.
		else {
			HttpSession session = request.getSession();
//            session.setAttribute("Name", userName);
			MyUtils.storeLoginedUser(session, user);

			// Nếu nguoi dùng chon tính năng "Remember me".
			if (remember) {
				MyUtils.storeUserCookie(response, user);
			}
			// Ngược lại xóa Cookie
			else {
				MyUtils.deleteUserCookie(response);
			}

			// Redirect (Chuyển hướng) sang trang /userInfo.
			response.sendRedirect(request.getContextPath() + "/userInfo");
		}
	}

}