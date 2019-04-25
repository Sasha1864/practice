package org.communis.practice.controller.view;

import lombok.extern.log4j.Log4j2;
import org.communis.practice.entity.Message;
import org.communis.practice.repository.UserRepository;
import org.communis.practice.service.MessageService;
import org.communis.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping(value = "admin/messages")
public class MessageController {
    private String USER_VIEWS_PATH = "admin/message/";

    @Autowired
    private final MessageService messageService;

    @Autowired
    private final UserService userService;

    @Autowired
    public MessageController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    /*@RequestMapping(value = "")
    public ModelAndView list(Pageable pageable, UserFilterWrapper filterUserWrapper) throws ServerException {
        ModelAndView usersPage = new ModelAndView(USER_VIEWS_PATH + "list");
        usersPage.addObject("filter", filterUserWrapper);
        usersPage.addObject("page", userService.getPageByFilter(pageable, filterUserWrapper));
        return usersPage;
    }*/
    @RequestMapping("/")
    public void test(){
        Message message = messageService.getById((long)1);
        System.out.println(message);
    }
}