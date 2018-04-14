package forum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {

	public static int addPost(Post p) {
		int status = 0;
		
		// status = 0 -> fail
		// status = 1 -> pass
				
		try {
			Connection con = MySqlConn.getConnection();
			
			PreparedStatement ps=con.prepareStatement("INSERT INTO `posts`(`text`, `id_thread`, `id_user`) VALUES (?,?,?)");
			ps.setString(1,p.getText());
			ps.setInt(2,p.getThreadId());
			ps.setInt(3, p.getUserId());
			status = ps.executeUpdate();
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	public static List<Post> viewAllPosts(int id) {
		List<Post> list = new ArrayList<Post>();
		try {
			Connection con = MySqlConn.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from posts where id_thread=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Post p = new Post();
				p.setPostId(rs.getInt(1));
				p.setText(rs.getString(2));
				p.setThreadId(rs.getInt(3));
				p.setUserId(rs.getInt(4));
						
				list.add(p);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}		
		return list;
	}
	
}
