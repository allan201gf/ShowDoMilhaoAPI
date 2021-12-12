package br.com.allangf.showdomilhaoapi.rest.service.impl;

import br.com.allangf.showdomilhaoapi.domain.entity.Category;
import br.com.allangf.showdomilhaoapi.domain.entity.Question;
import br.com.allangf.showdomilhaoapi.domain.enums.QuestionDifficultEnum;
import br.com.allangf.showdomilhaoapi.domain.exception.Errors;
import br.com.allangf.showdomilhaoapi.domain.exception.RuleOfException;
import br.com.allangf.showdomilhaoapi.domain.repository.CategoryRepository;
import br.com.allangf.showdomilhaoapi.domain.repository.QuestionRepository;
import br.com.allangf.showdomilhaoapi.rest.controller.CategoryController;
import br.com.allangf.showdomilhaoapi.rest.dto.QuestionDTO;
import br.com.allangf.showdomilhaoapi.rest.service.CategoryService;
import br.com.allangf.showdomilhaoapi.rest.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;
    private CategoryService categoryService;

    @Override
    public void createNewQuestion(QuestionDTO questionDTO) {

        List<Question> questionDuplicate = questionRepository.findByEnunciation(questionDTO.getEnunciation());

        if (!questionDuplicate.isEmpty()) {
            throw new RuleOfException(Errors.QUESTION_ALREADY_REGISTERED);
        }

        QuestionDifficultEnum questionDifficultEnum;

        switch (questionDTO.getDifficult()) {
            case "EASY":
                 questionDifficultEnum = QuestionDifficultEnum.EASY;
                 break;
            case "NORMAL":
                questionDifficultEnum = QuestionDifficultEnum.NORMAL;
                break;
            case "HARD":
                questionDifficultEnum = QuestionDifficultEnum.HARD;
                break;
            case "VERY HARD":
                questionDifficultEnum = QuestionDifficultEnum.VERY_HARD;
                break;
            default:
                throw new RuleOfException(Errors.INVALID_DIFFICULT);
        }

        Category category = categoryService.returnCategoryById(questionDTO.getCategory());

        Question question = new Question();
        question.setEnunciation(questionDTO.getEnunciation());
        question.setAnswer1(questionDTO.getAnswer1());
        question.setAnswer2(questionDTO.getAnswer2());
        question.setAnswer3(questionDTO.getAnswer3());
        question.setAnswer4(questionDTO.getAnswer4());
        question.setAnswerCorrect(questionDTO.getAnswerCorrect());
        question.setDifficult(questionDifficultEnum);
        question.setCategory(category);

        questionRepository.save(question);

    }

    @Override
    public void deleteQuestionById(int questionId) {
        try {
            questionRepository.deleteById(questionId);
        } catch (EmptyResultDataAccessException e) {
            throw new RuleOfException(Errors.QUESTION_NOT_FOUND);
        }
    }

    @Override
    public List<Question> returnAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public boolean checkCorrectQuestion(int questionId, String answer) {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new RuleOfException(Errors.CATEGORY_NOT_FOUND));
        return question.getAnswerCorrect().equals(answer);
    }

}
