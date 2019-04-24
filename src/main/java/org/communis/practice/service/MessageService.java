
package org.communis.practice.service;

import org.communis.practice.dto.MessageWrapper;
import org.communis.practice.entity.Message;
import org.communis.practice.entity.User;
import org.communis.practice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    /*public void edit(UserWrapper userWrapper) throws ServerException {
        try {
            User user = getById(userWrapper.getId());
            userWrapper.fromWrapper(user);
            userRepository.save(user);

        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_UPDATE_ERROR), ex);
        }
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Page getPageByFilter(Pageable pageable, UserFilterWrapper filterUserWrapper) throws ServerException {
        try {
            return userRepository.findAll(UserSpecification.build(filterUserWrapper), pageable)
                    .map(UserWrapper::new);
        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_LIST_ERROR), ex);
        }
    }*/
}
