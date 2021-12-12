package br.com.allangf.showdomilhaoapi.rest.service;

import br.com.allangf.showdomilhaoapi.domain.entity.Category;
import br.com.allangf.showdomilhaoapi.rest.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    void createNewCategory(CategoryDTO categoryDTO);
    void deleteCategoryById(int categoryid);
    List<Category> returnAllCategory();
    Category returnCategoryById(int categoryId);

}
