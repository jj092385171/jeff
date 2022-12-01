package MidtermProject01;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ispan.util.ConnectionFactory;

public class JDBCCRUBDemo {

	public static void main(String[] args) throws IOException {

		Connection conn = ConnectionFactory.createMSSQLConnection();
		highwayShoulderTableDao highSTD = new highwayShoulderTableDao(conn);

		try {
			while (true) {
				System.out.println("請輸入操作代號:" + "\n" + "C:新增 R:查詢 U:修改 D:刪除 E:結束 N:創建新CSV");
				Scanner s = new Scanner(System.in);
				String choose = s.nextLine();
				if (choose.toUpperCase().equals("E")) {
					System.out.println("----------程式結束----------");
					s.close();
					break;
				} else if (choose.toUpperCase().equals("C")) {

					System.out.println("請輸入國道編號");
					String number = s.next();
					System.out.println("請輸入國道所在路段");
					String segment = s.next();
					System.out.println("請輸入路段里程數");
					String mileage = s.next();
					System.out.println("請輸入預計開放時段");
					String timePeriod = s.next();
					System.out.println("請輸入路肩限速");
					String SpeedLimit = s.next();
					System.out.println("請輸入路肩類型編號");
					String shoulderType = s.next();

					highwayShoulderTable h1 = new highwayShoulderTable("國道" + number + "號", segment + "系統", mileage,
							timePeriod, SpeedLimit, "類型" + shoulderType);
					highSTD.addhighwayShoulder(h1);

					System.out.println("新增成功");
				} else if (choose.toUpperCase().equals("R")) {
					System.out.println("請輸入國道編號查詢相關資料");
					String shoulder = s.next();
					List<highwayShoulderTable> list = highSTD.findByRoute("國道" + shoulder + "號");

					if (list.size() > 0) {
						for (highwayShoulderTable hST : list) {
							System.out.println(hST);
						}
					} else {
						System.out.println("沒有相符的資料");
					}

				} else if (choose.toUpperCase().equals("U")) {

					System.out.println("請輸入路肩類型編號");
					String Type = s.next();
					System.out.println("請輸入路肩限速");
					String Speed = s.next();
					highSTD.updateshoulderSpeedLimit(Speed, Type);
					System.out.println("已修改類型" + Type + "為速限" + Speed);
				} else if (choose.toUpperCase().equals("D")) {
					System.out.println("請輸入國道類型編號");
					String no = s.next();
					highSTD.deletehighwayShoulder("類型" + no);
					System.out.println("已刪除類型");
				} else if (choose.toUpperCase().equals("N")) {
					System.out.println("若要輸出資料庫內所有檔案請按A，若要輸出找尋檔案請按B");
					String ab = s.next();
					if (ab.toUpperCase().equals("A")) {
						List<highwayShoulderTable> list = highSTD.findAllRoute();
						System.out.println("請輸入新建檔案名稱");
						highSTD.exportCSV(list);
						System.out.println("已將資料庫內所有資料輸出為csv");
					}
					if (ab.toUpperCase().equals("B")) {
						System.out.println("請輸入國道編號輸出相關資料為csv");
						String shoulder = s.next();
						List<highwayShoulderTable> list = highSTD.findByRoute("國道" + shoulder + "號");
						System.out.println("請輸入新建檔案名稱");
						highSTD.exportCSV(list);
						System.out.println("已將國道" + shoulder + "輸出為csv");
					} else {
						System.out.println("只能輸入A或B----將返回初始選項");
					}
				} else {
					System.out.println("----------無此指令----------");
				}
			}
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
