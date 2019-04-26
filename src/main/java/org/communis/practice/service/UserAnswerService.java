package org.communis.practice.service;

import org.communis.practice.dto.UserAnswerWrapper;
import org.communis.practice.entity.Answer;
import org.communis.practice.entity.User;
import org.communis.practice.entity.UserAnswer;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.repository.AnswerRepository;
import org.communis.practice.repository.UserAnswerRepository;
import org.communis.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerService {
    private UserAnswerRepository userAnswerRepository;

    private UserRepository userRepository;

    private AnswerRepository answerRepository;

    @Autowired
    public UserAnswerService(UserAnswerRepository userAnswerRepository, UserRepository userRepository, AnswerRepository answerRepository) {
        this.userAnswerRepository = userAnswerRepository;
        this.userRepository = userRepository;
        this.answerRepository = answerRepository;
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

    public void add(Long userId, Long answerId){
        User user = userRepository.findById(userId);
        Answer answer = answerRepository.findById(answerId);
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUser(user);
        userAnswer.setAnswer(answer);
        userAnswerRepository.save(userAnswer);
    }


    public void delete(Long id) {
        userAnswerRepository.delete(id);
    }

    public List<UserAnswer> findAll() {
        return userAnswerRepository.findAll();
    }
}
