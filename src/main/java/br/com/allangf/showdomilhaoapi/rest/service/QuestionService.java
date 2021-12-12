package br.com.allangf.showdomilhaoapi.rest.service;

import br.com.allangf.showdomilhaoapi.domain.entity.Category;
import br.com.allangf.showdomilhaoapi.domain.entity.Question;
import br.com.allangf.showdomilhaoapi.rest.dto.CategoryDTO;
import br.com.allangf.showdomilhaoapi.rest.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {

    void createNewQuestion(QuestionDTO categoryDTO);
    void deleteQuestionById(int questionId);
    List<Question> returnAllQuestion();
    boolean checkCorrectQuestion(int questionId, String answer);

}
