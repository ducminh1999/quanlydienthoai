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
import model.bean.Product;
import model.bean.UserAccount;
 
@WebServlet(urlPatterns = { "/editProduct" })
public class EditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public EditProductServlet() {
        super();
    }
 
    // Hien thi trang sua san pham.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
        if (loginedUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        }
        else {
	        Connection conn = MyUtils.getStoredConnection(request);
	        int code = Integer.parseInt(request.getParameter("code"));
	        Product product = null;
	        String errorString = null;
	        try {
	            product = MyDAO.findProduct(conn, code);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("product", product);
	        if (errorString != null && product == null) {
	            response.sendRedirect(request.getServletPath() + "/productList");
	            return;
	        }
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
	        dispatcher.forward(request, response);
        }
 
    }
 
    // Sau khi nguoi dung sua doi thong tin san pham, va nhan Submit.
    // Phuong thuc nay se duoc thuc thi.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String errorString = null;
        Connection conn = MyUtils.getStoredConnection(request);
    	HttpSession session = request.getSession();
        int code = Integer.parseInt(request.getParameter("code"));
        String name = (String) request.getParameter("name");
        String priceStr = (String) request.getParameter("price");
        float price = 0;
        if(name=="")
        	errorString="Bạn cần nhập tên sản phẩm";
        try {
            price = Float.parseFloat(priceStr);
        } catch (Exception e) {
        	errorString = "Price cần nhập một số thực";
        }
        if(priceStr=="")
        	errorString="Bạn cần nhập vào Price";
        Product product = new Product(code, name, price);
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
            dispatcher.forward(request, response);
        }
        else {
        	try {
                MyDAO.updateProduct(conn, product);
                session.setAttribute("add", "Đã edit sản phẩm có code = "+product.getCode()+" thành công");
            } catch (SQLException e) {
            }
            response.sendRedirect(request.getContextPath() + "/productList");
        }
    }
}
