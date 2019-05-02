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
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "questions/add")
    public void add(@Valid QuestionWrapper questionWrapper, BindingResult bindingResult) throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        questionService.add(questionWrapper);
    }

    @PutMapping(value = "/edit")
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

    @GetMapping(value = "")
    public List<Question> findAll(){
        return questionService.findAll();
    }

    @GetMapping(value = "{userId}/{countryId}")
    public List<Question> getQuestionsByCountryId(@PathVariable Long countryId) throws ServerException {
        return questionService.getQuestionsByCountryId(countryId);
    }

    @GetMapping(value = "{userId}/{countryId}/{questionId}")
    public List<Answer> getAnswersByQuestionId(@PathVariable Long countryId, @PathVariable Long questionId) throws ServerException {
        if(questionService.getQuestionsByCountryId(countryId).contains(questionService.getById(questionId))){
            List<Answer> answers = questionService.getAnswersByQuestionId(questionId);
            return answers;
        }
        return null;
    }

    @PostMapping(value = "{userId}/{countryId}/{questionId}/{answerId}")
    public void addUserAnswer(@PathVariable Long userId, @PathVariable Long answerId) {
        questionService.addUserAnswer(userId, answerId);
    }
}
