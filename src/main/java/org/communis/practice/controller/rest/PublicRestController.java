package org.communis.practice.controller.rest;

import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для публичного API
 *
 */
@RestController
@RequestMapping(value = "public")
public class PublicRestController {

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getCaInfo() {
        return "API simple info";
    }

}
