package org.communis.practice.controller.rest;

import org.communis.practice.entity.Answer;
import org.communis.practice.entity.Question;
import org.communis.practice.exception.ServerException;
import org.communis.practice.service.AnswerService;
import org.communis.practice.service.QuestionService;
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
    public TestRestController(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @GetMapping(value = "{id}")
    public List<Question> getQuestionsByCountryId(@PathVariable Long id) throws ServerException {
        return questionService.getQuestionsByCountryId(id);
    }
    @GetMapping(value = "{id}/{idQuestion}")
    public List<Answer> getanswersByQuestionId(@PathVariable Long id, @PathVariable Long idQuestion) throws ServerException {
        List<Answer> answers = answerService.getAnswersByQuestionId(idQuestion);
        return answers;
    }
}
