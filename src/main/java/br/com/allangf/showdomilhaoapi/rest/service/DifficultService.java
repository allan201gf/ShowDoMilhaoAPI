package br.com.allangf.showdomilhaoapi.rest.service;

import br.com.allangf.showdomilhaoapi.domain.entity.Question;
import br.com.allangf.showdomilhaoapi.domain.enums.QuestionDifficultEnum;
import br.com.allangf.showdomilhaoapi.rest.dto.QuestionDTO;

import java.util.List;

public interface DifficultService {

    List<QuestionDifficultEnum> returnAllDifficult();

}
