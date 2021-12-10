package br.com.allangf.showdomilhaoapi.domain.repository;

import br.com.allangf.showdomilhaoapi.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByCategoryName(String categoryName);

}
