package dev.valentinpichavant.controllers;

import dev.valentinpichavant.beans.Outlet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by dev.valentinpichavant on 10/16/16.
 */
@RestController
public class HomeController {

    @Autowired
    private Session session;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    protected ModelAndView test() {
        Transaction tx = session.beginTransaction();
        Outlet outlet = new Outlet();
        outlet.setActivated(true);
        session.save(outlet);
        tx.commit();
        return new ModelAndView("test");
    }
}
