package org.communis.practice.controller.rest;


import org.communis.practice.dto.UserAnswerWrapper;
import org.communis.practice.entity.UserAnswer;
import org.communis.practice.exception.InvalidDataException;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "userAnswers")
public class UserAnswerRestController {
    @Autowired
    private final UserAnswerService userAnswerService;

    @Autowired
    public UserAnswerRestController(UserAnswerService userAnswerService) {
        this.userAnswerService = userAnswerService;
    }

    @RequestMapping(value = "/add")
    public void add(@Valid UserAnswerWrapper userAnswerWrapper, BindingResult bindingResult) throws InvalidDataException, ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        userAnswerService.add(userAnswerWrapper);
    }

    @RequestMapping(value = "/edit")
    public void edit(@Valid UserAnswerWrapper userAnswerWrapper, BindingResult bindingResult)
            throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        userAnswerService.edit(userAnswerWrapper);
    }

    @GetMapping(value = "{id}")
    public UserAnswer getById(@PathVariable Long id){
        return userAnswerService.getById(id);
    }

    @GetMapping(value = "/list")
    public List<UserAnswer> findAll(){
        return userAnswerService.findAll();
    }

}
