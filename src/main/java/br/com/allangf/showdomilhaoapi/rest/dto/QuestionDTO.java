package br.com.allangf.showdomilhaoapi.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

    private String enunciation;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answerCorrect;
    private String difficult;
    private int category;


}
