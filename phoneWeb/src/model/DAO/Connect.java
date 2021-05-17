package model.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Connect {
	public static Connection getConnection() 
            throws ClassNotFoundException, SQLException {
       return getMySQLConnection();
  }
	
	public static Connection getMySQLConnection()
	        throws ClassNotFoundException, SQLException {
	    // Chú ý: Thay đổi các thông số kết nối cho phù hợp.
	    String hostName = "localhost";
	    String dbName = "studentmanagement";
	    String userName = "root";
	    String password = "root";
//	    String password = "VOKmdb36461";
	    return getMySQLConnection(hostName, dbName, userName, password);
	}
	 
	public static Connection getMySQLConnection(String hostName, String dbName,
	        String userName, String password) throws SQLException,
	        ClassNotFoundException {
	   
	    Class.forName("com.mysql.jdbc.Driver");
	 
	    // Cấu trúc URL Connection đối với MySQL:
	    // Ví dụ: 
	    // jdbc:mysql://localhost:3306/simplehr  
//	    String connectionURL = "jdbc:mysql://node238122-ltmndm10.j.layershift.co.uk:3306/" + dbName+"?autoReconnect=true&useSSL=false";
	    String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName+"?autoReconnect=true&useSSL=false";
	 
	    Connection conn = DriverManager.getConnection(connectionURL, userName,
	            password);
	    return conn;
	}
  public static void closeQuietly(Connection conn) {
      try {
          conn.close();
      } catch (Exception e) {
      }
  }

  public static void rollbackQuietly(Connection conn) {
      try {
          conn.rollback();
      } catch (Exception e) {
      }
  }
}

