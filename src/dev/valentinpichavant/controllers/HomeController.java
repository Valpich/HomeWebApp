package dev.valentinpichavant.controllers;

import dev.valentinpichavant.beans.Outlet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;


/**
 * Created by dev.valentinpichavant on 10/16/16.
 */
@RestController
public class HomeController {

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    protected ModelAndView test() {

        Outlet outlet = new Outlet();
        outlet.setActivated(true);
        outlet.setNumber(1);
        outlet.setDescription("Pich heater");
        outlet.setCreationTime(new Date());
        outlet.setModificationTime(new Date());
        Session session = localSessionFactoryBean.getObject().openSession();
        Transaction tx = session.beginTransaction();
        session.save(outlet);
        tx.commit();

        String query = "select ua from User ua where ua.email = :email";
        List results = session
                .createQuery(query)
                .setParameter("email", "test@gmail.com")
                .list();
        System.out.println(results.get(0));
        return new ModelAndView("test");
    }
}
