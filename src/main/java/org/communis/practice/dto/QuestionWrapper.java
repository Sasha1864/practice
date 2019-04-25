package org.communis.practice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.communis.practice.entity.Question;
import org.communis.practice.entity.User;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
public class QuestionWrapper implements ObjectWrapper<Question>, Serializable
{

    private Long id;

    @NotNull
    @Size(max = 100)
    private String question;


    public QuestionWrapper() {

    }

    public QuestionWrapper(Question question)
    {
        toWrapper(question);
    }

    @Override
    public void toWrapper(Question item)
    {
        if(item!=null)
        {
            id = item.getId();
            question = item.getQuestion();
        }
    }

    @Override
    public void fromWrapper(Question item) {
        if(item!=null) {
            item.setId(id);
            item.setQuestion(question);
        }
    }

}