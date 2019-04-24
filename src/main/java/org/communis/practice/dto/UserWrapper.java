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
    private final String EMAIL_REGEXP = "(.+@.+)";

    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 100)
    private String surname;

    @Size(max = 100)
    private String secondName;

    @NotNull
    @Size(max = 20)
    private String login;

    @NotNull
    @Size(max = 256)
    private String mail;

    @JsonIgnore
    @Size(min = 8, max = 20)
    private String password;

    @JsonIgnore
    @Size(min = 8, max = 20)
    private String confirmPassword;

    private Date dateLastOnline;
    private Date dateOpen;
    private Date dateClose;


    private Long idLdap;

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
            item.setLogin(login);
            item.setName(name);
            item.setSurname(surname);

        }
    }

    public String getFio() {
        return surname + " " + name + (secondName != null ? " " + secondName : "");
    }

    @AssertTrue
    public boolean isPasswordValid() {
        return (password == null && confirmPassword == null) ||
                (password != null && confirmPassword != null && password.equals(confirmPassword));
    }



}