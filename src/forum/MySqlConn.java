package forum;


import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConn {
	static Connection con = null;
	
	public static Connection getConnection() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://node8370-project.mj.milesweb.cloud/forum","root","XASrlc44944");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/forum","root","");
//			System.out.println("Database connected");
		}catch(Exception e){
			System.out.println(e);
//			System.out.println("Database is not connected");
		}
		return con;		
	}

}
