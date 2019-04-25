package org.communis.practice.dto;

import lombok.Data;
import org.communis.practice.entity.Message;
import org.communis.practice.entity.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class MessageWrapper implements ObjectWrapper<Message>, Serializable
{
    private Long id;

    @NotNull
    private User sender;

    @NotNull
    private User receiver;

    @Size(max = 255)
    private String message;


    public MessageWrapper() {

    }

    public MessageWrapper(Message message)
    {
        toWrapper(message);
    }

    @Override
    public void toWrapper(Message item)
    {
        if(item!=null)
        {
            id = item.getId();
            //id_sender = item.getSender().getId();
            //id_receiver = item.getReceiver().getId();
            message = item.getMessage();
        }
    }

    @Override
    public void fromWrapper(Message item) {
        if(item!=null) {
            item.setId(id);
            item.setMessage(message);
            //item.setReceiver(id_receiver);
        }
    }

}