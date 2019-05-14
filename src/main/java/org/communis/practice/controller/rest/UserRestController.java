package org.communis.practice.controller.rest;

import org.communis.practice.dto.UserWrapper;
import org.communis.practice.entity.User;
import org.communis.practice.exception.InvalidDataException;
import org.communis.practice.exception.ServerException;
import org.communis.practice.exception.error.ErrorCodeConstants;
import org.communis.practice.exception.error.ErrorInformationBuilder;
import org.communis.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "admin/users")
public class UserRestController {

    @Autowired
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public void add(@Valid UserWrapper userWrapper, BindingResult bindingResult) throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        userService.add(userWrapper);
    }

    @PutMapping("/edit")
    public void edit(@Valid UserWrapper userWrapper, BindingResult bindingResult)
            throws ServerException {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(ErrorInformationBuilder.build(ErrorCodeConstants.DATA_VALIDATE_ERROR));
        }
        userService.edit(userWrapper);
    }

    @GetMapping("/list")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

}