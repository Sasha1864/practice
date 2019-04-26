package org.communis.practice.controller.rest;

import org.communis.practice.entity.Question;
import org.communis.practice.exception.ServerException;
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
    public TestRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(value = "{id}")
    public List<Question> getQuestionsByCountryId(@PathVariable Long id) throws ServerException {
        List<Question> list = questionService.getQuestionsByCountry(id);
        return list;
    }
}
