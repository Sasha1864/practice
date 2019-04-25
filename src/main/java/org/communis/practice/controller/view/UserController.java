package org.communis.practice.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.practice.dto.UserWrapper;
import org.communis.practice.dto.filters.UserFilterWrapper;
import org.communis.practice.entity.User;
import org.communis.practice.exception.ServerException;
import org.communis.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Log4j2
@Controller
@RequestMapping(value = "admin/users")
public class UserController {
    private String USER_VIEWS_PATH = "admin/user/";

    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "")
    public ModelAndView list(Pageable pageable, UserFilterWrapper filterUserWrapper) throws ServerException {
        /*ModelAndView usersPage = new ModelAndView(USER_VIEWS_PATH + "list");
        usersPage.addObject("filter", filterUserWrapper);
        usersPage.addObject("page", userService.getPageByFilter(pageable, filterUserWrapper));
        return usersPage;*/
        ModelAndView usersPage = new ModelAndView(USER_VIEWS_PATH + "1");
        usersPage.addObject("user", userService.getById((long)1));
        /*usersPage.addObject("filter", filterUserWrapper);
        usersPage.addObject("page", userService.getPageByFilter(pageable, filterUserWrapper));*/
        return usersPage;
    }

    /*@RequestMapping("/")
    public void test(){
        System.out.println(userService.getById((long)1));
    }
*/

}