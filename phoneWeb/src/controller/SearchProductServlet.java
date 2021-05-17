package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

@WebServlet("/searchProduct")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public SearchProductServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        
        HttpSession session = request.getSession();
        UserAccount loginedUser = MyUtils.getLoginedUser(session);
        if (loginedUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
        	String search=request.getParameter("search");
        	String errorString = null;
            List<Product> list = null;
            try {
                list = MyDAO.findProductName(conn, search);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
            if(search=="")
            	response.sendRedirect(request.getContextPath() + "/productList");
            else {
    	        if(list.size()==0 || list == null) 
    	        	errorString = "Không tìm thấy kết quả cho: '" + search + "'";
    	        else {
    	        	errorString = "Tìm thấy " +list.size()+ " kết quả cho: '" + search + "'";
    	        }
            }
            request.setAttribute("errorString", errorString);
            request.setAttribute("productList", list);
            request.setAttribute("search", search);
             
            try {
                RequestDispatcher dispatcher = request.getServletContext()
                        .getRequestDispatcher("/WEB-INF/views/productListView.jsp");
            	dispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
        }
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 

}
