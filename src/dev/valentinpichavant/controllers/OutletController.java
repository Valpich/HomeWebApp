package dev.valentinpichavant.controllers;

import dev.valentinpichavant.beans.Outlet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * Created by valentinpichavant on 06/01/17.
 */
@Controller
public class OutletController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    LocalSessionFactoryBean localSessionFactoryBean;

    @RequestMapping(value = "/outlet", method = RequestMethod.GET)
    public ModelAndView showOutletPage(Principal principal) {
        if (principal == null) return new ModelAndView("user/login");
        Session session = localSessionFactoryBean.getObject().openSession();
        String query = "select outlet from Outlet outlet";
        List results = session.createQuery(query).list();
        ModelAndView modelAndView = new ModelAndView("outlet");
        modelAndView.addObject("outlets", results);
        return modelAndView;
    }

    @RequestMapping(value = "/outlet/add", method = RequestMethod.GET)
    public ModelAndView addOutlet(Principal principal) {
        if (principal == null) return new ModelAndView("user/login");
        Outlet outlet = new Outlet();
        outlet.setActivated(true);
        return new ModelAndView("outletAdd", "command", outlet);
    }

    @RequestMapping(value = "/outlet/add", method = RequestMethod.POST)
    public String addOutlet(@ModelAttribute Outlet outlet, Principal principal) {
        if (principal == null) return "redirect:/user/login";
        outlet.setCreationTime(new Date());
        outlet.setModificationTime(outlet.getCreationTime());
        Session session = localSessionFactoryBean.getObject().openSession();
        if (outlet.getActivated() == null) outlet.setActivated(new Boolean("false"));
        Transaction tx = session.beginTransaction();
        session.save(outlet);
        tx.commit();
        return "redirect:/outlet";
    }

    @RequestMapping(value = "/outlet/remove", method = RequestMethod.GET)
    public ModelAndView removeOutlet(Principal principal) {
        if (principal == null) return new ModelAndView("user/login");
        Session session = localSessionFactoryBean.getObject().openSession();
        String query = "select outlet from Outlet outlet";
        List results = session.createQuery(query).list();
        ModelAndView modelAndView = new ModelAndView("outletRemove");
        modelAndView.addObject("outlets", results);
        return modelAndView;
    }

    @RequestMapping(value = "/outlet/remove", method = RequestMethod.POST)
    public String removeOutlet(Long id, Principal principal) {
        if (principal == null) return "redirect:/user/login";
        Session session = localSessionFactoryBean.getObject().openSession();
        String query = "select outlet from Outlet outlet where outlet.id = :id";
        List results = session.createQuery(query).setParameter("id", id).list();
        Outlet outlet = (Outlet) results.get(0);
        Transaction tx = session.beginTransaction();
        session.delete(outlet);
        tx.commit();
        return "redirect:/outlet";
    }
}
