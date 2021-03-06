package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Product;
import model.bean.UserAccount;

public class MyDAO {

   public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {
       String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a " //
               + " where a.User_Name = ? and a.password= ?";
       PreparedStatement pstm = conn.prepareStatement(sql);
       pstm.setString(1, userName);
       pstm.setString(2, password);
       ResultSet rs = pstm.executeQuery();
       if (rs.next()) {
           String gender = rs.getString("Gender");
           UserAccount user = new UserAccount();
           user.setUserName(userName);
           user.setPassword(password);
           user.setGender(gender);
           return user;
       }
       return null;
   }

   public static UserAccount findUser(Connection conn, String userName) throws SQLException {
       String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a where a.User_Name = ? ";
       PreparedStatement pstm = conn.prepareStatement(sql);
       pstm.setString(1, userName);
       ResultSet rs = pstm.executeQuery();
       if (rs.next()) {
           String password = rs.getString("Password");
           String gender = rs.getString("Gender");
           UserAccount user = new UserAccount();
           user.setUserName(userName);
           user.setPassword(password);
           user.setGender(gender);
           return user;
       }
       return null;
   }

   public static List<Product> queryProduct(Connection conn) throws SQLException {
       String sql = "Select a.Code, a.Name, a.Price from Product a order by a.Code asc";
       PreparedStatement pstm = conn.prepareStatement(sql);
       ResultSet rs = pstm.executeQuery();
       List<Product> list = new ArrayList<Product>();
       while (rs.next()) {
           int code = rs.getInt("Code");
           String name = rs.getString("Name");
           float price = rs.getFloat("Price");
           Product product = new Product();
           product.setCode(code);
           product.setName(name);
           product.setPrice(price);
           list.add(product);
       }
       return list;
   }

   public static List<Product> findProductName(Connection conn, String search) throws SQLException {
       String sql = "Select a.Code, a.Name, a.Price from Product a where a.Name like '%"+search+"%';";
       PreparedStatement pstm = conn.prepareStatement(sql);
       ResultSet rs = pstm.executeQuery();
       List<Product> list = new ArrayList<Product>();
       while (rs.next()) {
    	   int code = rs.getInt("Code");
           String name = rs.getString("Name");
           float price = rs.getFloat("Price");
           Product product = new Product();
           product.setCode(code);
           product.setName(name);
           product.setPrice(price);
           list.add(product);
       }
       return list;
   }
   public static Product findProduct(Connection conn, int code) throws SQLException {
       String sql = "Select a.Code, a.Name, a.Price from Product a where a.Code=?";
       PreparedStatement pstm = conn.prepareStatement(sql);
       pstm.setInt(1, code);
       ResultSet rs = pstm.executeQuery();
       while (rs.next()) {
           String name = rs.getString("Name");
           float price = rs.getFloat("Price");
           Product product = new Product(code, name, price);
           return product;
       }
       return null;
   }

   public static void updateProduct(Connection conn, Product product) throws SQLException {
       String sql = "Update Product set Name =?, Price=? where Code=? ";
       PreparedStatement pstm = conn.prepareStatement(sql);
       pstm.setString(1, product.getName());
       pstm.setFloat(2, product.getPrice());
       pstm.setInt(3, product.getCode());
       pstm.executeUpdate();
       System.out.println("Update th??nh c??ng "+product.getName());
   }

   public static void insertProduct(Connection conn, Product product) throws SQLException {
       String sql = "Insert into Product(Code, Name, Price) values (?, ?,?)";
       PreparedStatement pstm = conn.prepareStatement(sql);
       pstm.setInt(1, product.getCode());
       pstm.setString(2, product.getName());
       pstm.setFloat(3, product.getPrice());
       pstm.executeUpdate();
       System.out.println("Th??m th??nh c??ng "+product.getName());
   }

   public static void deleteProduct(Connection conn, String code) throws SQLException {
       String sql = "Delete From Product where Code= ?";
       PreparedStatement pstm = conn.prepareStatement(sql);
       pstm.setString(1, code);
       pstm.executeUpdate();
       System.out.println("X??a th??nh c??ng s???n ph???m c?? code = "+code);
   }

}