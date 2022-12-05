package MidtermProject01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreatehighwayShoulderTable {
	
	private Connection conn;

	public CreatehighwayShoulderTable(Connection conn) {
		this.conn = conn;
	}
	
	public void createTable() throws SQLException {
		String sql = "create table highwayShoulder "
				+ "(route nvarchar(50),"
				+ "segment nvarchar(50),"
				+ "mileage nvarchar(50),"
				+ "timePeriod nvarchar(50),"
				+ "shoulderSpeedLimit nvarchar(50),"
				+ "shoulderType nvarchar(50));";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.execute();
		preState.close();
		System.out.println("create table success!!");
	}

	public static void main(String[] args) {
		Connection conn = ConnectionFactory.createMSSQLConnection();
		CreatehighwayShoulderTable cht = new CreatehighwayShoulderTable(conn);
		
		try {
			cht.createTable();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
