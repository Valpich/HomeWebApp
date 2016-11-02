package dev.valentinpichavant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by valentinpichavant on 11/1/16.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndexPage(Principal principal) {

        if (principal == null) return "user/login";
        return "index";
    }
}
