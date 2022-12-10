package T4_36.dao.impl;

import T4_36.dao.CategoryDao;
import T4_36.entity.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DbUtils;
import utils.ImageUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class CategoryDaoImpl implements CategoryDao {


    private final QueryRunner queryRunner = new QueryRunner();

    //     新增一筆記錄---
    @Override
    public boolean insert(Category category) throws SQLException {
        String sql = "INSERT INTO " + "category" +
                " ( userID, Pd_name, Pd_title, Pd_content, Pd_type, Pd_picture, Pd_price, Pd_inventory, Pd_date, Pd_last_update) " +
                "values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            Category result = queryRunner.insert(DbUtils.getConnection(), sql, new BeanHandler<>(Category.class),
                    category.getUserID(),
                    category.getPd_name(),
                    category.getPd_title(),
                    category.getPd_content(),
                    category.getPd_type(),
                    category.getPd_picture(),
                    category.getPd_price(),
                    category.getPd_inventory(),
                    category.getPd_date(),
                    category.getPd_last_update());

        return Objects.nonNull(result);
    }
    
    @Override
    public boolean inserttest(Category category) throws SQLException {
    	FileInputStream  in = null ;
//    	try {
//			in = ImageUtil.readImage(category.getPicture());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        String sql = "INSERT INTO " + "category" +
                " (userID, Pd_name, Pd_title, Pd_content, Pd_type, Pd_picture,  Pd_price, Pd_inventory, Pd_date ,Pd_last_update) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            Category resulttest = queryRunner.insert(DbUtils.getConnection(), sql, new BeanHandler<>(Category.class),
                    category.getUserID(),
                    category.getPd_name(),
                    category.getPd_title(),
                    category.getPd_content(),
                    category.getPd_type(),
                    category.getPd_picture(),
                    category.getPd_price(),
                    category.getPd_inventory(),
            		category.getPd_date(),
            		category.getPd_last_update());

        return Objects.nonNull(resulttest);
    }
    
    // 依Pd_id來刪除單筆記錄
    @Override
    public int deleteByPd_id(int id) throws SQLException {
        String sql = "DELETE FROM category WHERE Pd_id = ?";

        return queryRunner.update(DbUtils.getConnection(), sql, new BeanHandler<>(Category.class), id);
    }

    // 修改一筆書籍資料
    @Override
    public int update(Category category, long sizeInBytes) throws SQLException {
        String sql = "UPDATE category SET Pd_name =?, Pd_title =?, Pd_content =?, Pd_type =?, Pd_picture =?, Pd_price =?," +
                "Pd_inventory =?, Pd_date =?, Pd_last_update =?, WHERE Pd_id = ?";

        return queryRunner.update(DbUtils.getConnection(), sql, new BeanHandler<>(Category.class),
                category.getPd_name(),
                category.getPd_title(),
                category.getPd_content(),
                category.getPd_type(),
                category.getPd_picture(),
                category.getPd_picture(),
                category.getPd_inventory(),
                category.getPd_date(),
                category.getPd_last_update(),
                category.getPd_id());
    }

    @Override
    public Category selectByPd_id(int Pd_id) throws SQLException {
        String sql = "SELECT * FROM category WHERE Pd_id = ?";

        return queryRunner.query(DbUtils.getConnection(), sql, new BeanHandler<>(Category.class), Pd_id);
    }

    @Override
    public List<Category> selectAll() throws SQLException {
        String sql = "SELECT * FROM category";

        return queryRunner.query(DbUtils.getConnection(), sql, new BeanListHandler<>(Category.class));
    }
}
