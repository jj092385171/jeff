package T4_36.dao.impl;
/*
 * 一張合格的訂單必須經過下列檢查 
 * 
 * 	1.	檢查訂購之商品的數量是否足夠。
 *      此功能寫在本類別的updateProductStock()方法內，參考該方法的說明。
 */

// Repository

public class ProductOrderItemsDaoImpl implements OrderItemDao {
	
	private static Logger log = LoggerFactory.getLogger(ProductOrderItemsDaoImpl.class);
	
	Connection conn;

	public ProductOrderItemsDaoImpl() {
	}
	/*
	 * 計算客戶欲購買之某項商品(以OrderItemBean物件oib來表示)的小計金額(subtotal)， 
	 * 計算公式為: 商品的數量 * 商品的單價  * 商品的折扣
	 */
	@Override
	public double findItemAmount(OrderItemBean oib) {
		double subtotal = oib.getQuantity() * oib.getUnitPrice() * oib.getDiscount();
		return subtotal;
	}
	
//	@Override
//	public int findStockByBookId(Integer bookId) {
//		String sql = "SELECT stock FROM Book 3232";
//		int stock = 0;
//		try (
//			PreparedStatement ps = conn.prepareStatement(sql);
//		) {
//			ps.setInt(1, bookId);
//			try (ResultSet rs = ps.executeQuery();) {
//				if (rs.next()) {
//					stock = rs.getInt(1);
//				}
//			}
//			
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//			throw new RuntimeException("OrderItemDaoImpl類別#getStock()發生SQL例外: " + ex.getMessage());
//		}
//		log.info("訂單前期檢查之Dao, 找出商品(bookId=" + bookId + ")的庫存量(stock)=" + stock); 
//		return stock;
//	}

	@Override
	public void updateProductStock(OrderItemBean orderItemBean) {
		String sql1 = "UPDATE Book SET stock = stock - ? WHERE bookId = ?";
		try (PreparedStatement ps1 = conn.prepareStatement(sql1);) {
				ps1.setInt(1, orderItemBean.getQuantity());
				ps1.setInt(2, orderItemBean.getBookId());
				ps1.executeUpdate();
				log.info("orderItemBean=" + orderItemBean);
				log.info("處理訂單之Dao: 扣除庫存量，商品編號: getBookId()=" + orderItemBean.getBookId() + ", 扣除數量: " + orderItemBean.getQuantity() );
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("OrderItemDaoImpl類別#updateProductStock()發生SQL例外: " + ex.getMessage());
		}
	}
	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
}