package T4_36.dao;

import T4_36.entity.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {

    boolean insert(Category category) throws SQLException;

    int delete(int id) throws SQLException;

    int update(Category category) throws SQLException;

    Category select(int id) throws SQLException;

    List<Category> selectAll() throws SQLException;
}
