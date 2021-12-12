package br.com.allangf.showdomilhaoapi.rest.controller;

import br.com.allangf.showdomilhaoapi.domain.entity.Category;
import br.com.allangf.showdomilhaoapi.domain.entity.Question;
import br.com.allangf.showdomilhaoapi.domain.enums.QuestionDifficultEnum;
import br.com.allangf.showdomilhaoapi.rest.dto.CategoryDTO;
import br.com.allangf.showdomilhaoapi.rest.dto.QuestionDTO;
import br.com.allangf.showdomilhaoapi.rest.service.CategoryService;
import br.com.allangf.showdomilhaoapi.rest.service.DifficultService;
import br.com.allangf.showdomilhaoapi.rest.service.QuestionService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
@AllArgsConstructor
public class QuestionController {

    private QuestionService questionService;
    private DifficultService difficultService;

    @ApiOperation("Create new question")
    @PostMapping("/v1")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createNewCategory(@RequestBody QuestionDTO questionDTO) {
        questionService.createNewQuestion(questionDTO);
    }

    @ApiOperation("Delete question by id")
    @DeleteMapping("/v1")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestionById(@RequestParam int questionId) {
        questionService.deleteQuestionById(questionId);
    }

    @ApiOperation("Return all question")
    @GetMapping("/v1")
    public List<Question> returnAllQuestion() {
        return questionService.returnAllQuestion();
    }

    @ApiOperation("Return all difficult")
    @GetMapping("/v1/difficult")
    public List<QuestionDifficultEnum> returnAllDifficult() {
        return difficultService.returnAllDifficult();
    }

}
