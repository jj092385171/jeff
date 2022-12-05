package MidtermProject01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ispan.util.ConnectionFactory;

public class InsertCSV {
	private Connection conn;

	public InsertCSV(Connection conn) {
		this.conn = conn;
	}

	public static void main(String[] args) {
			Connection conn = ConnectionFactory.createMSSQLConnection();
			InsertCSV t = new InsertCSV(conn);
			try (
			FileInputStream is = new FileInputStream("C:\\JDBC\\國道實施開放路肩措施路段及時段一覽表1110908.csv");
			InputStreamReader isr = new InputStreamReader(is, "MS950");
			BufferedReader br = new BufferedReader(isr);){
			String strLine = null;
			while ((strLine = br.readLine()) != null) {// 將CSV檔字串一列一列讀入並存起來直到沒有列為止

				String[] array = strLine.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)",-1);// 因為預設是用"，"分開所以用split切開存入字串陣列
				System.out.println(strLine);
				String qryInsert = "insert into highwayShoulder values(?,?,?,?,?,?)";// 動態SQL指令

				PreparedStatement pstmt = conn.prepareStatement(qryInsert);// 因為是insert所以用PreparedStatement來接

				pstmt.setString(1, array[0]);
				pstmt.setString(2, array[1]);
				pstmt.setString(3, array[2]);
				pstmt.setString(4, array[3]);
				pstmt.setString(5, array[4]);
				pstmt.setString(6, array[5]);

				pstmt.execute();
				pstmt.close();
			};
			System.out.println("insert table success!!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}