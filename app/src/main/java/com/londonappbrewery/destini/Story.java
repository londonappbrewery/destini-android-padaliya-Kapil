package com.londonappbrewery.destini;

import java.io.Serializable;

public class Story implements Serializable {

    private Integer questionNumber ;
    private Integer questionText ;
    private Integer option1 ;
    private Integer option2 ;
    private Integer nextQuestionNumber1;
    private Integer nextQuestionNumber2;

    public Story(Integer questionNumber, Integer questionText, Integer option1, Integer option2, Integer nextQuestionNumber1, Integer nextQuestionNumber2) {
        this.questionNumber = questionNumber;
        this.questionText = questionText;
        this.option1 = option1;
        this.option2 = option2;
        this.nextQuestionNumber1 = nextQuestionNumber1;
        this.nextQuestionNumber2 = nextQuestionNumber2;
    }


    public Integer getQuestionText() {
        return questionText;
    }

    public Integer getOption1() {
        return option1;
    }

    public Integer getOption2() {
        return option2;
    }

    public Integer getNextQuestionNumber1() {
        return nextQuestionNumber1;
    }

    public Integer getNextQuestionNumber2() {
        return nextQuestionNumber2;
    }
}
