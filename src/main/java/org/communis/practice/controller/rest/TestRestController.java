package org.communis.practice.controller.rest;

import org.communis.practice.entity.Answer;
import org.communis.practice.entity.Question;
import org.communis.practice.exception.ServerException;
import org.communis.practice.service.AnswerService;
import org.communis.practice.service.QuestionService;
import org.communis.practice.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "test")
public class TestRestController {
    @Autowired
    private final QuestionService questionService;

    @Autowired
    private final AnswerService answerService;

    @Autowired
    private final UserAnswerService userAnswerService;

    @Autowired
    public TestRestController(QuestionService questionService, AnswerService answerService, UserAnswerService userAnswerService) {
        this.questionService = questionService;
        this.answerService = answerService;
        this.userAnswerService = userAnswerService;
    }

    @GetMapping(value = "{userId}/{countryId}")
    public List<Question> getQuestionsByCountryId(@PathVariable Long countryId) throws ServerException {
        return questionService.getQuestionsByCountryId(countryId);
    }
    @GetMapping(value = "{userId}/{countryId}/{idQuestion}")
    public List<Answer> getAnswersByQuestionId(@PathVariable Long countryId, @PathVariable Long idQuestion) throws ServerException {
        if(questionService.getQuestionsByCountryId(countryId).contains(questionService.getById(idQuestion))){
            List<Answer> answers = answerService.getAnswersByQuestionId(idQuestion);
            return answers;
        }
        return null;
    }

    @RequestMapping(value = "{userId}/{countryId}/{idQuestion}/{idAnswer}")
    public void addUserAnswer(@PathVariable Long userId, @PathVariable Long idAnswer) throws ServerException {
        userAnswerService.add(userId, idAnswer);
    }
}
