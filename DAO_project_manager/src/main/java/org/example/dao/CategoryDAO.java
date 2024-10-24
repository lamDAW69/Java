package org.example.dao;


import org.example.entities.Category;

import java.util.List;

public interface CategoryDAO {
    public List<Category> getCategories();
    public void insertCategory(Category category);
    public void deleteCategory(int id);
    public void updateCategory(Category category);
}
//It's created an interface called CategoryDAO that has the following methods. It has to be an interface so that it can be implemented by the CategoryDAOImpl class with all his methods.