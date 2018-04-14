package forum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ThreadDAO {

	public static int createThread(Threadd t, int uid) {
		int status = 0;
		// status = 0 -> fail
		// status = 1 -> pass
		
		try {
			Connection con = MySqlConn.getConnection();
			
			PreparedStatement ps=con.prepareStatement("INSERT INTO `threads`(`title`, `subject`, `id_user`) VALUES (?,?,?)");
			ps.setString(1,t.getTitle());
			ps.setString(2,t.getSubject());
			ps.setInt(3, uid);
			status = ps.executeUpdate();
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	public static List<Threadd> viewAllThreads() {
		List<Threadd> list = new ArrayList<Threadd>();
		try {
			Connection con = MySqlConn.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from threads");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Threadd t=new Threadd();
				t.setThreadId(rs.getInt(1));
				t.setTitle(rs.getString(2));
				t.setSubject(rs.getString(3));
				t.setUserId(rs.getInt(4));		
				list.add(t);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}		
		return list;
	}
	
	public static Threadd getThreadById(int id) {
		Threadd t = new Threadd();
		try{
			Connection con = MySqlConn.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from threads where id_thread=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				t.setThreadId(rs.getInt(1));
				t.setTitle(rs.getString(2));
				t.setSubject(rs.getString(3));
				t.setUserId(rs.getInt(4));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
//		System.our.println(t.getSubject());
		return t;
	}
	
	public static int updateThread(Threadd t) {
		int status = 0;
		// status = 0 -> fail
		// status = 1 -> pass
		
		try {
			Connection con = MySqlConn.getConnection();
			
			PreparedStatement ps=con.prepareStatement("UPDATE `threads` SET `title`=?,`subject`=? WHERE id_thread = ?");
			ps.setString(1,t.getTitle());
			ps.setString(2,t.getSubject());
			ps.setInt(3, t.getThreadId());
			status = ps.executeUpdate();
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
//	DELETE FROM `threads` WHERE id_thread = ?
			
	public static int deleteThread(int id) {
		int status = 0;
		// status = 0 -> fail
		// status = 1 -> pass
		
		try {
			Connection con = MySqlConn.getConnection();
			
			PreparedStatement ps=con.prepareStatement("DELETE FROM `threads` WHERE id_thread = ?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
}
