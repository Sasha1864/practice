
package org.communis.practice.service;

import org.communis.practice.dto.MessageWrapper;
import org.communis.practice.dto.filters.ObjectFilter;
import org.communis.practice.entity.Message;
import org.communis.practice.entity.User;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        messageRepository.delete(id);
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    /*public Page getPageByFilter(Pageable pageable, ObjectFilter filterUserWrapper) throws ServerException {
        try {
            return messageRepository.findAll(UserSpecification.build(filterUserWrapper), pageable)
                    .map(UserWrapper::new);
        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_LIST_ERROR), ex);
        }
    }*/
}
