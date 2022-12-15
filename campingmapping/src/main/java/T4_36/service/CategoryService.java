package T4_36.service;

import T4_36.entity.Category;

import java.util.List;

public interface CategoryService {

    void create(Category category);

    void delete(int id);

    void update(Category category);

    Category select(int id);
    
    Category findImgByPdiD(int id);

    List<Category> selectAll();
}
