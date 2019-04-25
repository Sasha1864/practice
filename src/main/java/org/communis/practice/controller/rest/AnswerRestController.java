package org.communis.practice.controller.rest;

import org.communis.practice.dto.AnswerWrapper;
import org.communis.practice.entity.Answer;
import org.communis.practice.exception.InvalidDataException;
import org.communis.practice.exception.NotFoundException;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.service.AnswerService;
import org.communis.practice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "answers")
public class AnswerRestController {
    @Autowired
    private final AnswerService answerService;

    @Autowired
    public AnswerRestController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @RequestMapping(value = "/add")
    public void add(@Valid AnswerWrapper answerWrapper, BindingResult bindingResult) throws InvalidDataException, ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        answerService.add(answerWrapper);
    }

    @RequestMapping(value = "/edit")
    public void edit(@Valid AnswerWrapper answerWrapper, BindingResult bindingResult)
            throws InvalidDataException, NotFoundException, ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        answerService.edit(answerWrapper);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public Answer getById(@Valid AnswerWrapper answerWrapper, BindingResult bindingResult)
            throws InvalidDataException, NotFoundException, ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        return answerService.getById(answerWrapper.getId());
    }

    @RequestMapping(value = "/list")
    public List<Answer> findAll(BindingResult bindingResult)
            throws InvalidDataException, NotFoundException, ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        return answerService.findAll();
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getCaInfo() {
        return answerService.findAll().toString();
    }
}
