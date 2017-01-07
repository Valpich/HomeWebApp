package dev.valentinpichavant.controllers;

import dev.valentinpichavant.beans.Outlet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by valentinpichavant on 1/6/17.
 */
@RestController
public class OutletAjaxController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    LocalSessionFactoryBean localSessionFactoryBean;


    @RequestMapping(value = "/outlet/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public boolean getCountryById(@PathVariable Long id) throws Exception {
        Session session = localSessionFactoryBean.getObject().openSession();
        String query = "select outlet from Outlet outlet where outlet.id = :id";
        List results = session.createQuery(query).setParameter("id", id).list();
        if (results != null) {
            Outlet outlet = (Outlet) results.get(0);
            //TODO: Execute outlet script
            outlet.setActivated(!outlet.getActivated());
            Transaction tx = session.beginTransaction();
            outlet.setModificationTime(new Date());
            session.update(outlet);
            tx.commit();
        }
        return true;
    }
}
