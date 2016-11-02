package dev.valentinpichavant.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by valentinpichavant on 11/1/16.
 */
@Controller
public class LogoutController {

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String showIndexPage() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:/";
    }
}
