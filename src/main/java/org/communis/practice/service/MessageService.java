
package org.communis.practice.service;

import org.communis.practice.dto.MessageWrapper;
import org.communis.practice.entity.Country;
import org.communis.practice.entity.Message;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message getById(Long id) {
        return messageRepository.findById(id);
    }

    public void add(MessageWrapper messageWrapper) {
        Message message = new Message();
        message.setDateCreate(new Date());
        messageWrapper.fromWrapper(message);

        messageRepository.save(message);
    }

    public void edit(MessageWrapper messageWrapper) throws ServerException {
        try {
            Message message = getById(messageWrapper.getId());
            messageWrapper.fromWrapper(message);
            messageRepository.save(message);

        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_UPDATE_ERROR), ex);
        }
    }

    public void delete(Long id) {
        Message message = messageRepository.findById(id);
        message.setDateClose(new Date());
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

}
