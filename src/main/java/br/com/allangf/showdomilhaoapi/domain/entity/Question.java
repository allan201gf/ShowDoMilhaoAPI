package br.com.allangf.showdomilhaoapi.domain.entity;

import br.com.allangf.showdomilhaoapi.domain.enums.QuestionDifficultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private int questionId;

    @Column(name = "enunciation")
    private String enunciation;

    @Column(name = "answer1")
    private String answer1;

    @Column(name = "answer2")
    private String answer2;

    @Column(name = "answer3")
    private String answer3;

    @Column(name = "answer4")
    private String answer4;

    @Column(name = "answer_correct")
    private String answerCorrect;

    private QuestionDifficultEnum difficult;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
