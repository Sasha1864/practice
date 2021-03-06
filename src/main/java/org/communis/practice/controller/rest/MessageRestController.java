package org.communis.practice.controller.rest;

import org.communis.practice.dto.MessageWrapper;
import org.communis.practice.entity.Message;
import org.communis.practice.exception.InvalidDataException;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("messages")
public class MessageRestController {

    @Autowired
    private final MessageService messageService;

    @Autowired
    public MessageRestController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/add")
    public void add(@Valid MessageWrapper messageWrapper, BindingResult bindingResult) throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        messageService.add(messageWrapper);
    }

    @PutMapping("/edit")
    public void edit(@Valid MessageWrapper messageWrapper, BindingResult bindingResult)
            throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        messageService.edit(messageWrapper);
    }

    @GetMapping("{id}")
    public Message getById(@PathVariable Long id){
        return messageService.getById(id);
    }

    @GetMapping("/list")
    public List<Message> findAll(){
        return messageService.findAll();
    }

}