package org.communis.practice.controller.rest;

import org.communis.practice.dto.QuestionWrapper;
import org.communis.practice.entity.Answer;
import org.communis.practice.entity.Question;
import org.communis.practice.exception.InvalidDataException;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "questions")
public class QuestionRestController {

    @Autowired
    private final QuestionService questionService;

    @Autowired
    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = "/add")
    public void add(@Valid QuestionWrapper questionWrapper, BindingResult bindingResult) throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        questionService.add(questionWrapper);
    }

    @RequestMapping(value = "/edit")
    public void edit(@Valid QuestionWrapper questionWrapper, BindingResult bindingResult)
            throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        questionService.edit(questionWrapper);
    }

    @GetMapping(value = "{id}")
    public Question getById(@PathVariable Long id){
        return questionService.getById(id);
    }

    @RequestMapping(value = "/list")
    public List<Question> findAll(BindingResult bindingResult)
            throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        return questionService.findAll();
    }

    @GetMapping(value = "{userId}/{countryId}")
    public List<Question> getQuestionsByCountryId(@PathVariable Long countryId) throws ServerException {
        return questionService.getQuestionsByCountryId(countryId);
    }

    @GetMapping(value = "{userId}/{countryId}/{idQuestion}")
    public List<Answer> getAnswersByQuestionId(@PathVariable Long countryId, @PathVariable Long idQuestion) throws ServerException {
        if(questionService.getQuestionsByCountryId(countryId).contains(questionService.getById(idQuestion))){
            List<Answer> answers = questionService.getAnswersByQuestionId(idQuestion);
            return answers;
        }
        return null;
    }

    @RequestMapping(value = "{userId}/{countryId}/{idQuestion}/{idAnswer}")
    public void addUserAnswer(@PathVariable Long userId, @PathVariable Long idAnswer) {
        questionService.addUserAnswer(userId, idAnswer);
    }
}
