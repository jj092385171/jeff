package _01_register.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _00_init.util.DBService;
import _01_register.dao.MemberDao;
import _01_register.model.MemberBean;
import _04_ShoppingCart.model.OrderBean;
// 本類別使用JDBC技術存取資料庫。
public class MemberDaoImpl_Jdbc implements MemberDao {
	
	private static Logger log = LoggerFactory.getLogger(MemberDaoImpl_Jdbc.class);
	
	private DataSource ds = null;
	private Connection conn = null;
	public MemberDaoImpl_Jdbc() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#建構子發生例外: " + ex.getMessage());
		}
	}
	// 
	// 儲存MemberBean物件，將參數mb新增到Member表格內。
	public void save(MemberBean mb) {
		log.info("會員註冊功能之Dao: 儲存會員資料");
		String sql = "insert into Member " 
				+ " (memberID, name, password, address, email, "
				+ " tel, userType, registerTime, totalAmt, memberImage," 
				+ " fileName, comment, unpaid_amount, mimeType) "
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, mb.getMemberId());
			ps.setString(2, mb.getName());
			
			ps.setString(3, mb.getPassword());
			ps.setString(4, mb.getAddress());
			ps.setString(5, mb.getEmail());
			ps.setString(6, mb.getTel());
			ps.setString(7, mb.getUserType());
			ps.setTimestamp(8, mb.getRegisterTime());
			
			ps.setDouble(9, mb.getTotalAmt());
			ps.setBlob(10, mb.getMemberImage());
			ps.setString(11, mb.getFileName());
			ps.setClob(12, mb.getComment());
			ps.setDouble(13, mb.getUnpaid_amount());
			ps.setString(14, mb.getMimeType());
			ps.executeUpdate();
			log.info("saveMember(), 新增成功：MemberBean=" + mb);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#saveMember()發生例外: " 
										+ ex.getMessage());
		}
	}
	// 判斷參數id(會員帳號)是否已經被現有客戶使用，如果是，傳回true，表示此id不能使用，
	// 否則傳回false，表示此id可使用。
	@Override
	public boolean existsById(String id) {
		log.info("會員註冊功能之Dao: 檢查會員輸入的編號是否已被使用");
		boolean exist = false;
		String sql = "SELECT * FROM Member WHERE memberID = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					exist = true;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#idExists()發生例外: " 
					+ ex.getMessage());
		}
		log.info("會員註冊功能之Dao: 檢查會員輸入的編號是否已被使用, exist=" + exist);
		return exist;
	}
	
	// 由參數 id (會員帳號) 到Member表格中 取得某個會員的所有資料，傳回值為一個MemberBean物件，
	// 如果找不到對應的會員資料，傳回值為null。
	@Override
	public MemberBean findByMemberId(String id) {
		log.info("會員登入功能之Dao: 檢查帳號/密碼"); 
		MemberBean mb = null;
		String sql = "SELECT * FROM Member WHERE memberId = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					mb = new MemberBean();
					mb.setPkey(rs.getInt("seqNo"));
					mb.setMemberId(rs.getString("memberId"));
					mb.setName(rs.getString("name"));
					mb.setPassword(rs.getString("password"));
					mb.setAddress(rs.getString("address"));
					mb.setEmail(rs.getString("email"));
					mb.setTel(rs.getString("tel"));
					mb.setUserType(rs.getString("userType"));
					mb.setRegisterTime(rs.getTimestamp("RegisterTime"));
					mb.setTotalAmt(rs.getDouble("totalAmt"));
					mb.setMemberImage(rs.getBlob("MemberImage"));
					mb.setComment(rs.getClob("Comment"));
					mb.setFileName(rs.getString("filename"));
					mb.setUnpaid_amount(rs.getDouble("Unpaid_amount"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#queryMember()發生例外: " 
					+ ex.getMessage());
		}
		log.info("會員登入功能之Dao: 取得某個會員的資料, mb=" + mb);
		return mb;
	}
	// 檢查使用者在登入時輸入的帳號與密碼是否正確。如果正確，傳回該帳號所對應的MemberBean物件，
	// 否則傳回 null。
	@Override
	public MemberBean findByMemberIdAndPassword(String memberId, String password) {
		MemberBean mb = null;
		String sql = "SELECT * FROM Member m WHERE m.memberId = ? and m.password = ?";
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, memberId);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					mb = new MemberBean();
					mb.setPkey(rs.getInt("seqNo"));
					mb.setMemberId(rs.getString("memberId"));
					mb.setName(rs.getString("name"));
					mb.setPassword(rs.getString("password"));
					mb.setAddress(rs.getString("address"));
					mb.setEmail(rs.getString("email"));
					mb.setTel(rs.getString("tel"));
					mb.setUserType(rs.getString("userType"));
					mb.setRegisterTime(rs.getTimestamp("registerTime"));
					mb.setTotalAmt(rs.getDouble("totalAmt"));
					mb.setMemberImage(rs.getBlob("memberImage"));
					mb.setFileName(rs.getString("filename"));
					mb.setMimeType(rs.getString("mimeType"));
					mb.setComment(rs.getClob("comment"));
					mb.setUnpaid_amount(rs.getDouble("Unpaid_amount"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#checkIDPassword()發生SQL例外: " 
					+ ex.getMessage());
		}
		log.info("會員登入功能之Dao: 檢查帳號/密碼結果:" 
				+ (mb == null ? "帳號/密碼正確" : "帳號/密碼錯誤"));
		return mb;
	}
	/*
	*/
	@Override
	public void updateUnpaidAmount(OrderBean ob) {
		log.info("處理訂單之memberDao: 更新MemberBean之未付款金額以便儲存最新的未付款餘額");
		double currentAmount = ob.getTotalAmount(); // 取出該訂單的總金額
		// 更新Member表格之未付款餘額欄位 unpaid_amount
		String sql1 = "UPDATE Member SET unpaid_amount = unpaid_amount + ? " 
		            + " WHERE memberId = ?";
		
		try (
			PreparedStatement ps1 = conn.prepareStatement(sql1);
		) {
			ps1.setDouble(1, currentAmount);
			ps1.setString(2, ob.getMemberId());
			ps1.executeUpdate();
			log.info("處理訂單之memberDao: 已更新Member表格之未付款餘額欄位, 新增的數量=" + currentAmount);
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#updateUnpaidOrderAmount()發生SQL例外: " + ex.getMessage());
		}
	}
	
	@Override
	public void setConnection(Connection conn) {
        this.conn = conn;
	}
}
