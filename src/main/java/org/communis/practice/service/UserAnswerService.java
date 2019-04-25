package org.communis.practice.service;

import org.communis.practice.dto.UserAnswerWrapper;
import org.communis.practice.entity.UserAnswer;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.repository.UserAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerService {
    private UserAnswerRepository userAnswerRepository;
    @Autowired
    public UserAnswerService(UserAnswerRepository userAnswerRepository) {
        this.userAnswerRepository = userAnswerRepository;
    }

    public UserAnswer getById(Long id) {
        return userAnswerRepository.findById(id);
    }

    public void add(UserAnswerWrapper userAnswerWrapper) {
        UserAnswer userAnswer = new UserAnswer();
        userAnswerWrapper.fromWrapper(userAnswer);

        userAnswerRepository.save(userAnswer);
    }

    public void edit(UserAnswerWrapper userAnswerWrapper) throws ServerException {
        try {
            UserAnswer userAnswer = getById(userAnswerWrapper.getId());
            userAnswerWrapper.fromWrapper(userAnswer);
            userAnswerRepository.save(userAnswer);

        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_UPDATE_ERROR), ex);
        }
    }

    public void delete(Long id) {
        userAnswerRepository.delete(id);
    }

    public List<UserAnswer> findAll() {
        return userAnswerRepository.findAll();
    }
}
