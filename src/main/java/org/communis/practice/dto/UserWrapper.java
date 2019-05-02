package org.communis.practice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.communis.practice.entity.User;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
public class UserWrapper implements ObjectWrapper<User>, Serializable
{

    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 100)
    private String surname;

    @NotNull
    @Size(max = 20)
    private String login;

    @JsonIgnore
    private String password;


    public UserWrapper() {

    }

    public UserWrapper(User user)
    {
        toWrapper(user);
    }

    @Override
    public void toWrapper(User item)
    {
        if(item!=null)
        {
            id = item.getId();
            name = item.getName();
            surname = item.getSurname();
            login = item.getLogin();
            password = item.getPassword();
        }
    }

    @Override
    public void fromWrapper(User item) {
        if(item!=null) {
            item.setId(id);
            item.setLogin(login);
            item.setName(name);
            item.setSurname(surname);
            item.setPassword(password);
        }
    }
}