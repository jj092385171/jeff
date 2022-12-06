package T4_36.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import T4_36.dao.ProductOrderDao;
import T4_36.entity.ProductOrder;
import T4_36.entity.ProductOrderItems;

//本類別
//1.新增一筆訂單到orders表格
//2.查詢orders表格內的單筆訂單
//3.查詢orders表格內的所有訂單
public class ProductOrderDaoImpl implements ProductOrderDao {

	private static Logger log = LoggerFactory.getLogger(ProductOrderDaoImpl.class);

	private Connection con;
	int orderNo = 0;

	public ProductOrderDaoImpl() {
	}

	@Override
	public void save(ProductOrder productOrder) {
		log.info("儲存訂單(OrderDaoImpl)之Dao: ");
		String sqlOrder = "Insert Into productOrder "
				+ " (Od_status, od_date,"
				+ " od_last_update, user_id, od_shipping_name,"
				+ "Pd_price, od_shipping_address, od_shipping_email,"
				+ "od_shipping_phone, od_shipping_postal_code, od_shipping_cost) "
				+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		String sqlItem = "Insert Into productOrderItems (seqno, orderID,"
				+ " Pd_id, Pd_name, od_shipping_name, Pd_price) "
				+ " values(?, ?, ?, ?, ?, ?) ";

		ResultSet generatedKeys = null;

		try (PreparedStatement ps = con.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);) {
			ps.setInt(1, productOrder.getOrderID());
			ps.setString(2, productOrder.getOd_status());
			Timestamp tsod = new Timestamp(productOrder.getOd_date().getTime());
			ps.setTimestamp(3, tsod);
			Timestamp tsolu = new Timestamp(productOrder.getOd_last_update().getTime());
			ps.setTimestamp(4, tsolu);
			ps.setString(5, productOrder.getUser_id());
			ps.setString(6, productOrder.getOd_shipping_name());
			ps.setInt(7, productOrder.getPd_price());
			ps.setString(8, productOrder.getOd_shipping_address());
			ps.setString(9, productOrder.getOd_shipping_email());
			ps.setString(10, productOrder.getOd_shipping_phone());
			ps.setString(11, productOrder.getOd_shipping_postal_code());
			ps.setInt(12, productOrder.getOd_shipping_cost());
			ps.executeUpdate();
			log.info("處理訂單之Dao: 新增一筆訂單到orders表格= " + productOrder);
			int id = 0;
			// 取回剛才新增之訂單的主鍵值
			generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
			} else {
				throw new RuntimeException("ProductOrderDaoImpl類別#insertOrder()無法取得新增之productOrder表格的主鍵");

			}
			Set<ProductOrderItems> items = productOrder.getItems();
			try (PreparedStatement ps2 = con.prepareStatement(sqlItem);) {
				for (ProductOrderItems oib : items) {
					ps2.setInt(1, id);
					ps2.setInt(2, oib.getPd_id());
					ps2.setString(3, oib.getPd_name());
					ps2.setString(4, oib.getOd_shipping_name());
					ps2.setInt(5, oib.getPd_price());
					ps2.executeUpdate();
					log.info("處理訂單之Dao: 新增一筆OrderItemBean到OrderItemBean表格= " + oib);
					ps2.clearParameters();
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("OrderDaoImpl類別#insertOrder()發生SQL例外: " + ex.getMessage());
		}
	}

	@Override
	public ProductOrder findById(int orderNo) {
		log.info("依照orderNo編號讀取特定一筆訂單的所有資料之Dao, orderNo=" + orderNo);
		ProductOrder ob = null;
		DataSource ds = null;
		Set<ProductOrderItems> set = null;
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("OrderDaoImpl類別#getOrder()-1發生例外: " + ex.getMessage());
		}

		String sql = "SELECT * FROM Orders WHERE orderno = ? ";
		String sql1 = "SELECT * FROM OrderItems WHERE orderno = ? ";
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				PreparedStatement ps1 = con.prepareStatement(sql1);) {
			ps.setInt(1, orderNo);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					Integer no = rs.getInt("orderNo");
					String bno = rs.getString("bno");
					String title = rs.getString("invoiceTitle");
					String id = rs.getString("memberId");
					Timestamp orderDate = rs.getTimestamp("orderDate");
					String shipAddr = rs.getString("shippingAddress");
					Date shipDate = rs.getDate("shippingDate");
					double totalAmount = rs.getDouble("totalAmount");
					ob = new OrderBean(no, id, totalAmount, shipAddr, bno, title, orderDate, shipDate, null);
				}
			}
			ps1.setInt(1, orderNo);
			try (ResultSet rs = ps1.executeQuery();) {
				set = new HashSet<>();
				while (rs.next()) {
					int seqNo = rs.getInt("seqNo");
					int orderNo2 = rs.getInt("orderNo");
					int bookId = rs.getInt("bookId");
					String description = rs.getString("description");
					Integer amount = rs.getInt("amount");
					Double uPrice = rs.getDouble("unitPrice");
					Double discount = rs.getDouble("discount");
					OrderItemBean oib = new OrderItemBean(seqNo, orderNo2, bookId, description, amount, uPrice,
							discount, null, null, null);
					set.add(oib);
				}
				ob.setItems(set);
				log.info("依照orderNo編號讀取特定一筆訂單的所有資料之Dao, 讀取完畢, ob=" + ob);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("OrderDaoImpl類別#getOrder()-2發生例外: " + ex.getMessage());
		}
		return ob;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	@Override
	public List<OrderBean> findByMemberId(String memberId) {
		log.info("讀取某位會員所有訂單之Dao: 開始");
		DataSource ds = null;
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("OrderDaoImpl類別#getOrder()-1發生例外: " + ex.getMessage());
		}
		List<OrderBean> list = new ArrayList<OrderBean>();
		String sql = "SELECT OrderNo FROM Orders where memberId = ? Order by orderDate desc ";
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, memberId);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					Integer no = rs.getInt(1);
					list.add(findById(no));
				}
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		log.info("讀取某位會員所有訂單之Dao: 讀取完畢");
		return list;
	}

	@Override
	public OrderBean findById(int orderNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderBean> findByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(ProductOrder ob) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProductOrder findById(int orderNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<ProductOrder> findByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConnection(Connection con) {
		// TODO Auto-generated method stub

	}

}