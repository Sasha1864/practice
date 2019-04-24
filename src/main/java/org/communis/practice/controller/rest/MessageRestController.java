package org.communis.practice.controller.rest;

import org.communis.practice.dto.MessageWrapper;
import org.communis.practice.exception.InvalidDataException;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "admin/messages")
public class MessageRestController {

    private final MessageService messageService;

    @Autowired
    public MessageRestController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void add(@Valid MessageWrapper messageWrapper, BindingResult bindingResult) throws InvalidDataException, ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        messageService.add(messageWrapper);
    }

    /*@RequestMapping(value = "", method = RequestMethod.PATCH)
    public void editPersonal(@Valid UserWrapper userWrapper, BindingResult bindingResult)
            throws InvalidDataException, NotFoundException, ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        userService.edit(userWrapper);
    }*/

}