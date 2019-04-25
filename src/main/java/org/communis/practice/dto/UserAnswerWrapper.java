package org.communis.practice.dto;

import lombok.Data;
import org.communis.practice.entity.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class UserAnswerWrapper implements ObjectWrapper<UserAnswer>, Serializable {

    private Long id;

    @NotNull
    private User user;

    @NotNull
    private Answer answer;


    public UserAnswerWrapper() {

    }

    public UserAnswerWrapper(UserAnswer userAnswer)
    {
        toWrapper(userAnswer);
    }

    @Override
    public void toWrapper(UserAnswer item)
    {
        if(item!=null)
        {
            id = item.getId();
            user = item.getUser();
            answer = item.getAnswer();
        }
    }

    @Override
    public void fromWrapper(UserAnswer item) {
        if(item!=null) {
            item.setAnswer(answer);
            item.setUser(user);
        }
    }
}

