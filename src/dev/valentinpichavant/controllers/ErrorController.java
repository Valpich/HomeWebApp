package dev.valentinpichavant.controllers;

/**
 * Created by valentinpichavant on 1/7/17.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    @RequestMapping(value = "/error404", method = RequestMethod.GET)
    public ModelAndView renderErrorPage() {
        return new ModelAndView("error404");
    }
}