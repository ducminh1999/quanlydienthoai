package model.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import model.DAO.Connect;
import model.DAO.MyUtils;

@WebFilter(filterName = "jdbcFilter", urlPatterns = { "/*" })
public class JDBCFilter implements Filter {

   public JDBCFilter() {
   }

   @Override
   public void init(FilterConfig fConfig) throws ServletException {

   }

   @Override
   public void destroy() {

   }

   // Kiểm tra mục tiêu của request hiện tại là 1 Servlet?
   private boolean needJDBC(HttpServletRequest request) {
       System.out.println("JDBC Filter");
       // Servlet Url-pattern: /spath/*
       // => /spath
       
       String servletPath = request.getServletPath();
       // => /abc/mnp
       String pathInfo = request.getPathInfo();
       String urlPattern = servletPath;
       if (pathInfo != null) {
           // => /spath/*
           urlPattern = servletPath + "/*";
       }

       // Key: servletName.
       // Value: ServletRegistration
       Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext()
               .getServletRegistrations();
       // Tập hợp tất cả các Servlet trong WebApp của bạn.
       Collection<? extends ServletRegistration> values = servletRegistrations.values();
       for (ServletRegistration sr : values) {
           Collection<String> mappings = sr.getMappings();
           if (mappings.contains(urlPattern)) {
               return true;
           }
       }
       return false;
   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
           throws IOException, ServletException {

       HttpServletRequest req = (HttpServletRequest) request;
       // Chi mi connection đoi voi cac request co duong dan dac biet.
       // (Chang han duong dan toi cac servlet, jsp, ..)
       if (this.needJDBC(req)) {

           System.out.println("Open Connection for: " + req.getServletPath());

           Connection conn = null;
           try {
               conn = Connect.getConnection();
               conn.setAutoCommit(false);
               MyUtils.storeConnection(request, conn);

               // Cho phep request di tiep.
               chain.doFilter(request, response);
               // dui phuong thuc commit() de hoan thanh giao dich voi DB.
               conn.commit();
           } catch (Exception e) {
               e.printStackTrace();
               Connect.rollbackQuietly(conn);
           } finally {
               Connect.closeQuietly(conn);
           }
       }
       // Voi cac request thong thuong (image, css, html,..)
       // khong csn mo connection.
       else {
           chain.doFilter(request, response);
       }

   }

}
