package dev.valentinpichavant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by valentinpichavant on 11/1/16.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showIndexPage(Principal principal) {
        if (principal == null) return new ModelAndView("user/login");
        return new ModelAndView("index");
    }
}
