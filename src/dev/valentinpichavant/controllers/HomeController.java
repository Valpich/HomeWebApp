package dev.valentinpichavant.controllers;

import dev.valentinpichavant.beans.Outlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

/**
 * Created by dev.valentinpichavant on 10/16/16.
 */
@RestController
public class HomeController {

    @PostConstruct
    public void init() {
        System.out.print("Instianciated");
    }

    @Autowired
    private Outlet outlet;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    protected ModelAndView test() {
        return new ModelAndView("test");
    }
}
