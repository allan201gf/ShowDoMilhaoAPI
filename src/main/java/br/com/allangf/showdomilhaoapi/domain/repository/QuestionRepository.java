package br.com.allangf.showdomilhaoapi.domain.repository;

import br.com.allangf.showdomilhaoapi.domain.entity.Category;
import br.com.allangf.showdomilhaoapi.domain.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByEnunciation(String enunciation);

}
