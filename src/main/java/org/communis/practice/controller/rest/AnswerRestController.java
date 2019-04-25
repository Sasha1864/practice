package org.communis.practice.controller.rest;

import org.communis.practice.dto.AnswerWrapper;
import org.communis.practice.entity.Answer;
import org.communis.practice.exception.InvalidDataException;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public void add(@Valid AnswerWrapper answerWrapper, BindingResult bindingResult) throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        answerService.add(answerWrapper);
    }

    @RequestMapping(value = "/edit")
    public void edit(@Valid AnswerWrapper answerWrapper, BindingResult bindingResult)
            throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        answerService.edit(answerWrapper);
    }

    @GetMapping(value = "{id}")
    public Answer getById(@PathVariable Long id){
        return answerService.getById(id);
    }

    @RequestMapping(value = "/list")
    public List<Answer> findAll(BindingResult bindingResult)
            throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        return answerService.findAll();
    }

}
