package org.communis.practice.dto;

import lombok.Data;
import org.communis.practice.entity.Answer;
import org.communis.practice.entity.Country;
import org.communis.practice.entity.Question;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AnswerWrapper implements ObjectWrapper<Answer>, Serializable {

    private Long id;

    @NotNull
    private String answer;

    @NotNull
    private Boolean status;

    @NotNull
    private Question question;

    @Override
    public void toWrapper(Answer item)
    {
        if(item!=null)
        {
            id = item.getId();
            answer = item.getAnswer();
            status = item.getStatus();
            question = item.getQuestion();
        }
    }

    @Override
    public void fromWrapper(Answer item) {
        if(item!=null) {
            item.setAnswer(answer);
            item.setStatus(status);
            item.setQuestion(question);
        }
    }
}
