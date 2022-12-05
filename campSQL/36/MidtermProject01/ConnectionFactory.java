package MidtermProject01;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	public static Connection createMSSQLConnection() {
		Properties props = new Properties();
		
		FileInputStream fis = null;
		Connection conn = null;
		
		try {
			fis = new FileInputStream("src\\db.properties");
			props.load(fis);
			conn = DriverManager.getConnection(props.getProperty("MMSQL_DB_URL"),
					props.getProperty("MMSQL_DB_UserName"), props.getProperty("MMSQL_DB_Password"));
			
		} catch (SQLException | IOException e) {
			System.out.println("連線有問題");
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
