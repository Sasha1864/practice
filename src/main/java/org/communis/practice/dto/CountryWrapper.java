package org.communis.practice.dto;

import lombok.Data;
import org.communis.practice.entity.Country;
import org.communis.practice.entity.Message;
import org.communis.practice.entity.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class CountryWrapper implements ObjectWrapper<Country>, Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String image;


    @Override
    public void toWrapper(Country item)
    {
        if(item!=null)
        {
            id = item.getId();
            name = item.getName();
            image = item.getImage();
        }
    }

    @Override
    public void fromWrapper(Country item) {
        if(item!=null) {
            item.setId(id);
            item.setName(name);
            item.setImage(image);
        }
    }

}
