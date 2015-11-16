package global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	public static void main(String[] args) {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName(Constants.HSQL_DRIVER);
            conn = DriverManager.getConnection(
					Constants.HSQL_URL,
					Constants.HSQL_ID,
					Constants.HSQL_PASSWORD);
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery("select * from TEST ");
				String id = null;
				while (rs.next()) {
					id = rs.getString("userid");
				}
				System.out.println("ID : "+id);
        } catch (Exception e ) {
            System.out.println("HSQLDB 에러발생 !!");
            e.printStackTrace();
            return;
        } 
	}
}
