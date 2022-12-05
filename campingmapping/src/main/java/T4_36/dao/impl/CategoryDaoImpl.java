package T4_36.dao.impl;

import T4_36.dao.CategoryDao;
import T4_36.entity.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class CategoryDaoImpl implements CategoryDao {


    private final QueryRunner queryRunner = new QueryRunner();

    private final Connection connection = DbUtils.getConnection();

    @Override
    public boolean insert(Category category) throws SQLException {
        String sql = "INSERT INTO `" + "category" +
                "` (Pd_id, UID, name, title, content, type, picture, price, inventory, Pd_date, Pd_last_update) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            Category result = queryRunner.insert(connection, sql, new BeanHandler<>(Category.class),
                    category.getPd_id(),
                    category.getUID(),
                    category.getName(),
                    category.getTitle(),
                    category.getContent(),
                    category.getType(),
                    category.getPicture(),
                    category.getPicture(),
                    category.getInventory(),
                    category.getPd_date(),
                    category.getPd_last_update());

        return Objects.nonNull(result);
    }

    @Override
    public int delete(int id) throws SQLException {
        String sql = "DELETE FROM category WHERE Pd_id = ?";

        return queryRunner.update(connection, sql, new BeanHandler<>(Category.class), id);
    }

    @Override
    public int update(Category category) throws SQLException {
        String sql = "UPDATE category SET name =?, title =?, content =?, type =?, picture =?, price =?," +
                "inventory =?, Pd_date =?, Pd_last_update =?, WHERE Pd_id = ?";

        return queryRunner.update(connection, sql, new BeanHandler<>(Category.class),
                category.getName(),
                category.getTitle(),
                category.getContent(),
                category.getType(),
                category.getPicture(),
                category.getPicture(),
                category.getInventory(),
                category.getPd_date(),
                category.getPd_last_update(),
                category.getPd_id());
    }

    @Override
    public Category select(int id) throws SQLException {
        String sql = "SELECT * FROM category WHERE Pd_id = ?";

        return queryRunner.query(connection, sql, new BeanHandler<>(Category.class), id);
    }

    @Override
    public List<Category> selectAll() throws SQLException {
        String sql = "SELECT * FROM category";

        return queryRunner.query(connection, sql, new BeanListHandler<>(Category.class));
    }
}
