package MidtermProject01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class highwayShoulderTableDao {

	private Connection conn;

	public highwayShoulderTableDao(Connection conn) {
		this.conn = conn;
	}

	// 新增資料
	public void addhighwayShoulder(highwayShoulderTable HST) throws SQLException {
		String sql = "insert into highwayShoulder values (?,?,?,?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, HST.getRoute());
		preState.setString(2, HST.getSegment());
		preState.setString(3, HST.getMileage());
		preState.setString(4, HST.getTimePeriod());
		preState.setString(5, HST.getShoulderSpeedLimit());
		preState.setString(6, HST.getShoulderType());
		int row = preState.executeUpdate();
		System.out.println("新增了 " + row + " 筆");
		preState.close();
	}
//123
	// 透過路線拿資料
	public List<highwayShoulderTable> findByRoute(String route) throws SQLException {
		String sql = "select * from highwayShoulder where route = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, route);

		ResultSet rs = preState.executeQuery();

		List<highwayShoulderTable> list = new LinkedList<highwayShoulderTable>();

		while (rs.next()) {

			highwayShoulderTable hST = new highwayShoulderTable();

			hST.setRoute(rs.getString("route"));
			hST.setSegment(rs.getString("segment"));
			hST.setMileage(rs.getString("mileage"));
			hST.setTimePeriod(rs.getString("timePeriod"));
			hST.setShoulderSpeedLimit(rs.getString("shoulderSpeedLimit"));
			hST.setShoulderType(rs.getString("shoulderType"));
			list.add(hST);
		}

		rs.close();
		preState.close();

		return list;
	}

	// 給類型改速限
	public void updateshoulderSpeedLimit(String splimit, String shoulderType) throws SQLException {
		String sql = "update highwayShoulder set shoulderSpeedLimit = ? where shoulderType = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, splimit);
		preState.setString(2, shoulderType);

		preState.executeUpdate();

		System.out.println("修改完成!!");

		preState.close();
	}

	// 刪除資料用國道編號找
	public void deletehighwayShoulder(String shoulderType) throws SQLException {
		String sql = "delete from highwayShoulder where shoulderType = ?";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, shoulderType);
		preState.executeUpdate();
		System.out.println("刪除 OK");
		preState.close();
	}

	//  取出所有國道資料
	public List<highwayShoulderTable> findAllRoute() throws SQLException {
		String sql = "select * from highwayShoulder";
		PreparedStatement preState = conn.prepareStatement(sql);

		ResultSet rs = preState.executeQuery();

		List<highwayShoulderTable> list = new LinkedList<highwayShoulderTable>();

		while (rs.next()) {

			highwayShoulderTable hST = new highwayShoulderTable();

			hST.setRoute(rs.getString("route"));
			hST.setSegment(rs.getString("segment"));
			hST.setMileage(rs.getString("mileage"));
			hST.setTimePeriod(rs.getString("timePeriod"));
			hST.setShoulderSpeedLimit(rs.getString("shoulderSpeedLimit"));
			hST.setShoulderType(rs.getString("shoulderType"));
			list.add(hST);
		}

		rs.close();
		preState.close();

		return list;
	}
	//讀取資料，輸出為CSV
	public void exportCSV(List<highwayShoulderTable> list) throws SQLException {
		try {
			Scanner sc = new Scanner(System.in);
			String address = sc.next();
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\JDBC\\" + address + ".csv"));//檔案輸出路徑
			StringBuilder stringBuffer = new StringBuilder();
			stringBuffer.append("路線,路段,里程數,時段,路肩速限,路肩類型").append(System.lineSeparator());
			for (highwayShoulderTable shoulderTable: list) {
				stringBuffer.append(shoulderTable.getRoute()).append(",");
				stringBuffer.append(shoulderTable.getSegment()).append(",");
				stringBuffer.append(shoulderTable.getMileage()).append(",");
				stringBuffer.append(shoulderTable.getTimePeriod()).append(",");
				stringBuffer.append(shoulderTable.getShoulderSpeedLimit()).append(",");
				stringBuffer.append(shoulderTable.getShoulderType());

				stringBuffer.append(System.lineSeparator());
			}

			bw.write(stringBuffer.toString());
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
