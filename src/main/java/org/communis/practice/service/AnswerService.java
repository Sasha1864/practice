package org.communis.practice.service;

import org.communis.practice.dto.AnswerWrapper;
import org.communis.practice.entity.Answer;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    private AnswerRepository answerRepository;
    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer getById(Long id) {
        return answerRepository.findById(id);
    }

    public void add(AnswerWrapper answerWrapper) {
        Answer answer = new Answer();
        answerWrapper.fromWrapper(answer);

        answerRepository.save(answer);
    }

    public void edit(AnswerWrapper answerWrapper) throws ServerException {
        try {
            Answer answer = getById(answerWrapper.getId());
            answerWrapper.fromWrapper(answer);
            answerRepository.save(answer);

        } catch (Exception ex) {
            throw new ServerException(ErrorInformationBuilder.build(ErrorCodeConstants.USER_UPDATE_ERROR), ex);
        }
    }

    public void delete(Long id) {
        answerRepository.delete(id);
    }

    public List<Answer> findAll() {
        return answerRepository.findAll();
    }
}
