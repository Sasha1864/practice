package org.communis.practice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.communis.practice.entity.Country;
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

    @NotNull
    private Country country;


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
            country = item.getCountry();
            question = item.getQuestion();
        }
    }

    @Override
    public void fromWrapper(Question item) {
        if(item!=null) {
            item.setQuestion(question);
            item.setCountry(country);
        }
    }

}