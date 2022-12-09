package T4_36.service;

import T4_36.entity.Category;

import java.util.List;

public interface CategoryService {

    void create(Category category);

    void delete(int id);

    static void update(Category category, long sizeInBytes) {
		// TODO Auto-generated method stub
		
	}

    Category select(int id);

    List<Category> selectAll();
}
