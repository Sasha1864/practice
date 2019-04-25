package org.communis.practice.service;

import org.communis.practice.dto.QuestionWrapper;
import org.communis.practice.entity.Question;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;
    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getById(Long id) {
        return questionRepository.findById(id);
    }

    public void add(QuestionWrapper questionWrapper) {
        Question question = new Question();
        questionWrapper.fromWrapper(question);

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

    public void delete(Long id) {
        questionRepository.delete(id);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }
}
