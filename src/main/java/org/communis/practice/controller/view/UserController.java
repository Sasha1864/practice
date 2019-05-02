package org.communis.practice.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.practice.dto.UserWrapper;
import org.communis.practice.dto.filters.UserFilterWrapper;
import org.communis.practice.entity.User;
import org.communis.practice.exception.ServerException;
import org.communis.practice.service.CountryService;
import org.communis.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Log4j2
@Controller
@RequestMapping(value = "admin")
public class UserController {
    private String USER_VIEWS_PATH = "admin/user/";

    @Autowired
    private final UserService userService;

    @Autowired
    private  final CountryService countryService;

    @Autowired
    public UserController(UserService userService, CountryService countryService) {
        this.userService = userService;
        this.countryService = countryService;
    }

    @RequestMapping(value = "users")
    public ModelAndView list(Pageable pageable, UserFilterWrapper filterUserWrapper) {
        ModelAndView usersPage = new ModelAndView(USER_VIEWS_PATH + "1");
        usersPage.addObject("users", userService.findAll());
        return usersPage;
    }

    @RequestMapping("countries")
    public ModelAndView countriesList(){
        ModelAndView usersPage = new ModelAndView(USER_VIEWS_PATH + "countries");
        usersPage.addObject("countries", countryService.findAll());
        return usersPage;
    }
}