package org.communis.practice.dto;

import lombok.Data;
import org.communis.practice.entity.Message;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class MessageWrapper implements ObjectWrapper<Message>, Serializable
{
    private Long id;

    @NotNull
    private Long id_sender;

    @NotNull
    private Long id_receiver;

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
            id_sender = item.getId_sender();
            id_receiver = item.getId_receiver();
            message = item.getMessage();
        }
    }

    @Override
    public void fromWrapper(Message item) {
        if(item!=null) {
            item.setId_sender(id_sender);
            item.setId_receiver(id_receiver);
            item.setMessage(message);
        }
    }

}