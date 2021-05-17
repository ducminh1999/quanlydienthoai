package model.DAO;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.UserAccount;

public class MyUtils {
//	static Cookie cookieUserName;
   public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";

   private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

   // Luu tru Connection vao attribute cua request.
   public static void storeConnection(ServletRequest request, Connection conn) {
       request.setAttribute(ATT_NAME_CONNECTION, conn);
   }

   // Lay doi tuong Connection da duoc luu tru trong attribute cua request.
   public static Connection getStoredConnection(ServletRequest request) {
       Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
       return conn;
   }

   // Luu tru thong tin nguoi dung da login vao Session.
   public static void storeLoginedUser(HttpSession session, UserAccount loginedUser) {
       // Tren JSP co the truy cap thong qua ${loginedUser}
       session.setAttribute("loginedUser", loginedUser);
   }

   // Lay thong tin nguoi dung luu tru trong Session.
   public static UserAccount getLoginedUser(HttpSession session) {
       UserAccount loginedUser = (UserAccount) session.getAttribute("loginedUser");
       return loginedUser;
   }

   // Luu thong tin nguoi dung vao Cookie.
   public static void storeUserCookie(HttpServletResponse response, UserAccount user) {
       System.out.println("Store user cookie");
       Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getUserName());
       // 1 ngay (da doi ra giay)
       cookieUserName.setMaxAge(24 * 60 * 60);
       response.addCookie(cookieUserName);
   }

   public static String getUserNameInCookie(HttpServletRequest request) {
       Cookie[] cookies = request.getCookies();
       if (cookies != null) {
           for (Cookie cookie : cookies) {
               if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                   return cookie.getValue();
               }
           }
       }
       return null;
   }

   // Xoa Cookie của nguoi dung
   public static void deleteUserCookie(HttpServletResponse response) {
//       System.out.println("aaa_"+cookieUserName +"---"+cookieUserName.getValue());
       Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
       // 0 giây. (Cookie này sẽ hết hiệu lực ngay lập tức)
       cookieUserName.setMaxAge(0);
//       System.out.println("aaa_"+cookieUserName +"---"+cookieUserName.getValue());
       response.addCookie(cookieUserName);
   }

}
