package T4_36.dao.impl;

import T4_36.dao.CategoryDao;
import T4_36.entity.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DbUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class CategoryDaoImpl implements CategoryDao {


    private final QueryRunner queryRunner = new QueryRunner();

    //     新增一筆記錄---
    @Override
    public boolean insert(Category category) throws SQLException {
        String sql = "INSERT INTO " + "category" +
                " ( userID, Pdname, Pdtitle, Pdcontent, Pdtype, Pdpicture, Pdprice, Pdinventory, Pddate, Pdlastupdate) " +
                "values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            Category result = queryRunner.insert(DbUtils.getConnection(), sql, new BeanHandler<>(Category.class),
                    category.getUserID(),
                    category.getPdname(),
                    category.getPdtitle(),
                    category.getPdcontent(),
                    category.getPdtype(),
                    category.getPdpicture(),
                    category.getPdprice(),
                    category.getPdinventory(),
                    category.getPddate(),
                    category.getPdlastupdate());

        return Objects.nonNull(result);
    }
    
    
    // 依Pd_id來刪除單筆記錄
    @Override
    public int deleteByPd_id(int id) throws SQLException {
        String sql = "DELETE FROM category WHERE Pdid = ?";

        return queryRunner.update(DbUtils.getConnection(), sql, new BeanHandler<>(Category.class), id);
    }

    // 修改一筆書籍資料
    @Override
    public int update(Category category, long sizeInBytes) throws SQLException {
        String sql = "UPDATE category SET Pdname =?, Pdtitle =?, Pdcontent =?, Pdtype =?, Pdpicture =?, Pdprice =?," +
                "Pdinventory =?, Pddate =?, Pdlastupdate =?, WHERE Pdid = ?";

        return queryRunner.update(DbUtils.getConnection(), sql, new BeanHandler<>(Category.class),
                category.getPdname(),
                category.getPdtitle(),
                category.getPdcontent(),
                category.getPdtype(),
                category.getPdpicture(),
                category.getPdpicture(),
                category.getPdinventory(),
                category.getPddate(),
                category.getPdlastupdate(),
                category.getPdid());
    }

    @Override
    public Category selectByPd_id(int Pd_id) throws SQLException {
        String sql = "SELECT * FROM category WHERE Pd_id = ?";

        return queryRunner.query(DbUtils.getConnection(), sql, new BeanHandler<Category>(Category.class), Pd_id);
    }

    @Override
    public List<Category> selectAll()  {
        String sql = "SELECT * FROM category";

        try {
        	System.out.println("s");
			List<Category> query = queryRunner.query(DbUtils.getConnection(), sql, new BeanListHandler<Category>(Category.class));
			query.forEach(a -> System.out.println(a.toString()));	
			System.out.println("a");
			
			return query;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }

}
