package org.communis.practice.controller.rest;

import org.communis.practice.dto.QuestionWrapper;
import org.communis.practice.entity.Question;
import org.communis.practice.exception.InvalidDataException;
import org.communis.practice.exception.NotFoundException;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public void add(@Valid QuestionWrapper questionWrapper, BindingResult bindingResult) throws InvalidDataException, ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        questionService.add(questionWrapper);
    }

    @RequestMapping(value = "/edit")
    public void edit(@Valid QuestionWrapper questionWrapper, BindingResult bindingResult)
            throws InvalidDataException, NotFoundException, ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        questionService.edit(questionWrapper);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Question getById(@Valid QuestionWrapper questionWrapper, BindingResult bindingResult)
            throws InvalidDataException, NotFoundException, ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        return questionService.getById(questionWrapper.getId());
    }

    @RequestMapping(value = "/list")
    public List<Question> findAll(BindingResult bindingResult)
            throws InvalidDataException, NotFoundException, ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        return questionService.findAll();
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getCaInfo() {
        return questionService.findAll().toString();
    }
}
