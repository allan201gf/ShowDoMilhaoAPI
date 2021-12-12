package br.com.allangf.showdomilhaoapi.rest.service.impl;

import br.com.allangf.showdomilhaoapi.domain.entity.Question;
import br.com.allangf.showdomilhaoapi.domain.enums.QuestionDifficultEnum;
import br.com.allangf.showdomilhaoapi.domain.exception.Errors;
import br.com.allangf.showdomilhaoapi.domain.exception.RuleOfException;
import br.com.allangf.showdomilhaoapi.domain.repository.QuestionRepository;
import br.com.allangf.showdomilhaoapi.rest.dto.QuestionDTO;
import br.com.allangf.showdomilhaoapi.rest.service.DifficultService;
import br.com.allangf.showdomilhaoapi.rest.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DifficultServiceImpl implements DifficultService {

    @Override
    public List<QuestionDifficultEnum> returnAllDifficult() {
        return List.of(QuestionDifficultEnum.EASY, QuestionDifficultEnum.NORMAL, QuestionDifficultEnum.HARD, QuestionDifficultEnum.VERY_HARD);
    }

}
