package br.com.allangf.showdomilhaoapi.rest.controller;

import br.com.allangf.showdomilhaoapi.domain.entity.Category;
import br.com.allangf.showdomilhaoapi.rest.dto.CategoryDTO;
import br.com.allangf.showdomilhaoapi.rest.service.CategoryService;
import br.com.allangf.showdomilhaoapi.rest.service.CategoryServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @ApiOperation("Create new category")
    @PostMapping("/v1")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createNewCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.createNewCategory(categoryDTO);
    }

    @ApiOperation("Delete category by name")
    @DeleteMapping("/v1")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoryById(@RequestParam int categoryid) {
        categoryService.deleteCategoryById(categoryid);
    }

    @ApiOperation("Return all category")
    @GetMapping("/v1")
    public List<Category> returnAllCategory() {
        return categoryService.returnAllCategory();
    }

}
