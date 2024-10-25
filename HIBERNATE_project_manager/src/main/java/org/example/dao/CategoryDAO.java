package org.example.dao;
import java.util.List;

import org.example.entities.Category;

public interface CategoryDAO {
    public List<Category> getCategories();
    public int insertCategory(Category categoria);
    public void deleteCategory(int id);
    public void updateCategory(Category categoria);
}
