package org.communis.practice.service;

import org.communis.practice.dto.CountryWrapper;
import org.communis.practice.dto.QuestionWrapper;
import org.communis.practice.dto.UserWrapper;
import org.communis.practice.dto.filters.QuestionFilterWrapper;
import org.communis.practice.dto.filters.UserFilterWrapper;
import org.communis.practice.entity.*;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.repository.AnswerRepository;
import org.communis.practice.repository.QuestionRepository;
import org.communis.practice.repository.UserAnswerRepository;
import org.communis.practice.repository.UserRepository;
import org.communis.practice.repository.specifications.AnswerSpecification;
import org.communis.practice.repository.specifications.QuestionSpecification;
import org.communis.practice.repository.specifications.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;
    private UserAnswerRepository userAnswerRepository;
    private UserRepository userRepository;
    private AnswerRepository answerRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, UserAnswerRepository userAnswerRepository, UserRepository userRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.userAnswerRepository = userAnswerRepository;
        this.userRepository = userRepository;
        this.answerRepository = answerRepository;
    }

    public Question getById(Long id) {
        return questionRepository.findById(id);
    }

    public void add(QuestionWrapper questionWrapper) {
        Question question = new Question();
        questionWrapper.fromWrapper(question);
        question.setDateCreate(new Date());
        questionRepository.save(question);
    }

    public void edit(QuestionWrapper questionWrapper) throws ServerException {
        try {
            Question question = getById(questionWrapper.getId());
            questionWrapper.fromWrapper(question);
            questionRepository.save(question);

        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_UPDATE_ERROR), ex);
        }
    }

    public void addUserAnswer(Long userId, Long answerId){
        User user = userRepository.findById(userId);
        Answer answer = answerRepository.findById(answerId);
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setUser(user);
        userAnswer.setDateCreate(new Date());
        userAnswer.setAnswer(answer);
        userAnswerRepository.save(userAnswer);
    }
    public void delete(Long id) {
        Question question = questionRepository.findById(id);
        question.setDateClose(new Date());
    }

    public List<Question> findAllQuestions() {
        return questionRepository.findAll();
    }

    public List<UserAnswer> findAllUserAnswers() {
        return userAnswerRepository.findAll();
    }

   public List<Question> getQuestionsByCountryId(Long id) throws ServerException {
       try {
           QuestionSpecification spec = new QuestionSpecification(id);
           List<Question> result = questionRepository.findAll(spec);
           return result;
       } catch (Exception ex) {
           throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_LIST_ERROR), ex);
       }
   }
    public List<Answer> getAnswersByQuestionId(Long id) throws ServerException {
        try {
            AnswerSpecification spec = new AnswerSpecification(id);
            List<Answer> result = answerRepository.findAll(spec);
            return result;
        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_LIST_ERROR), ex);
        }
    }
}
