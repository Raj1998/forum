package forum;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	public static int addUser(User u) {
		int status = 0;
		// status = 0 -> fail
		// status = 1 -> pass
		// status = 9 -> duplicate found
		try {
			Connection con = MySqlConn.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from users where BINARY username = ?");
			pst.setString(1,u.getUserName());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				status = 9;
			}
			else {
				PreparedStatement ps=con.prepareStatement("INSERT INTO `users`(`username`, `email`, `password`) values (?,?,?)");
				ps.setString(1,u.getUserName());
				ps.setString(2,u.getUserEmail());
				ps.setString(3,u.getUserPassword());
				status = ps.executeUpdate();
			}
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static User authenticate(String userName, String password) {
		User u = null;
		
		try {
			Connection con = MySqlConn.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users where BINARY username = ? and BINARY password = ?");
			ps.setString(1,userName);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u = new User();
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setUserEmail(rs.getString(3));
				u.setUserPassword(rs.getString(4));
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public static String getUserById(int id) {
		String name = null;
		try {
			Connection con = MySqlConn.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users where id_user=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				name = rs.getString(2);
			}
			else {
				name = "Unknown";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
	public static int getUserByName(String name) {
		int id = -1;
		try {
			Connection con = MySqlConn.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users where BINARY username=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				id = rs.getInt("id_user");
			}
			else {
				id = -1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return id; 
	}
	
	public static int sendMessage(Message m) {
		int status = 0;
		// status = 0 -> fail
		// status = 1 -> pass
		try {
			Connection con = MySqlConn.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from users where BINARY id_user = ?");
			pst.setInt(1,m.getR_id());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				PreparedStatement ps=con.prepareStatement("INSERT INTO `messages`(`sender_id`, `receiver_id`, `title`, `message`, `sender_status`, `receiver_status`) VALUES (?,?,?,?,?,?)");
				
				ps.setInt(1,m.getS_id());
				ps.setInt(2,m.getR_id());
				ps.setString(3,m.getTitle());
				ps.setString(4,m.getMessage());
				ps.setInt(5, m.getS_status());
				ps.setInt(6, m.getR_status());
				
				status = ps.executeUpdate();
				
			}
			else
			{
				status = -1;
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static List<Message> getMessagesById(int id){
		List<Message> list = new ArrayList<Message>();
		try {
			Connection con = MySqlConn.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from messages where receiver_id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Message m=new Message();
				m.setId(rs.getInt(1));
				m.setS_id(rs.getInt(2));
				m.setR_id(rs.getInt(3));
				m.setTitle(rs.getString(4));
				m.setMessage(rs.getString(5));
				m.setS_status(rs.getInt(7));
				m.setR_status(rs.getInt(8));
				
				list.add(m);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}		
		return list;
	}
	
}
