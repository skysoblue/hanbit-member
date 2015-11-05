package global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import member.MemberVO;

public class JdbcTest {
	public static void main(String[] args) {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String url = "jdbc:hsqldb:C:/jse/MyDB;readonly=true" ;
        String user = "sa";
        String pass = "";
       
        // import 단축키 : CTRL + SHIFT + O
       
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (Exception e ) {
            System.out.println("HSQLDB 에러발생 !!");
            e.printStackTrace();
            return;
        } 
        try {
			conn = DriverManager.getConnection(url,user,pass);
			if (conn != null) {
				System.out.println("커넥션 널 아님");
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery("select * from TEST ");
				String id = null;
				while (rs.next()) {
					id = rs.getString("userid");
				}
				System.out.println("ID : "+id);
			}else{
				System.out.println("커넥션 널 !!!!!!!!!!!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
