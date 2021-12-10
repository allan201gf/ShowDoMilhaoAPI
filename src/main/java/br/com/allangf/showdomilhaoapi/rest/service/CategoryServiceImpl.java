package br.com.allangf.showdomilhaoapi.rest.service;

import br.com.allangf.showdomilhaoapi.domain.entity.Category;
import br.com.allangf.showdomilhaoapi.domain.exception.Errors;
import br.com.allangf.showdomilhaoapi.domain.exception.RuleOfException;
import br.com.allangf.showdomilhaoapi.domain.repository.CategoryRepository;
import br.com.allangf.showdomilhaoapi.rest.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public void createNewCategory(CategoryDTO categoryDTO) {

        List<Category> categoryDuplicate = categoryRepository.findByCategoryName(categoryDTO.getCategory());

        if (!categoryDuplicate.isEmpty()) {
            throw new RuleOfException(Errors.CATEGORY_ALREADY_REGISTERED);
        }

        Category category = new Category();
        category.setCategoryName(categoryDTO.getCategory());

        categoryRepository.save(category);

    }

    @Override
    public void deleteCategoryById(int categoryid) {
        try {
            categoryRepository.deleteById(categoryid);
        } catch (EmptyResultDataAccessException e) {
            throw new RuleOfException(Errors.CATEGORY_NOT_FOUND);
        }
    }

}
