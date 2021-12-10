package br.com.allangf.showdomilhaoapi.rest.service;

import br.com.allangf.showdomilhaoapi.rest.dto.CategoryDTO;

public interface CategoryService {

    void createNewCategory(CategoryDTO categoryDTO);
    void deleteCategoryById(int categoryid);

}
