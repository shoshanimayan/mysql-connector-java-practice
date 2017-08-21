import java.sql.*;

public class connectToDB{
  public static void main(String[] args){
    Connection conn = null;
    try{
      String userName = "root";
      String password ="espeon123";
      String url = "jdbc:mysql://localhost/test?autoReconnect=true&useSSL=false";
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      //conn = DriverManager.getConnection("jdbc:mysql://localhost/test?autoReconnect=true&useSSL=false" +"user=root&password=espeon123");
      conn= DriverManager.getConnection(url,userName,password);
      System.out.println("connection succesful");
    }
    catch(SQLException e){
      System.out.println("SQLException: " + e.getMessage());
      System.out.println("SQLState: " + e.getSQLState());
      System.out.println("VendorError: " + e.getErrorCode());
      System.out.println("connection failed");
    }
    catch(Exception e){
      System.out.println("connection failed");
    }
    finally{
      if(conn !=null){
        try{
          conn.close();
          System.out.println("database connection closed");

        }
        catch(Exception e){
          System.out.println("database connection cannot be closed");
        }
      }
    }
  }
}
