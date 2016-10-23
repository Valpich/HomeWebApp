package dev.valentinpichavant.repositories;

import dev.valentinpichavant.beans.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by valentinpichavant on 10/21/16.
 */
@Repository
public class UserRepository {

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    public User findByEmail(String email) {

        Session session = localSessionFactoryBean.getObject().openSession();

        String query = "select ua from User ua where ua.email = :email";
        List results = session
                .createQuery(query)
                .setParameter("email", email)
                .list();
        if (!results.isEmpty()) {
            return (User) results.get(0);
        } else {
            return null;
        }
    }

    public User save(User user) {
        Session session = localSessionFactoryBean.getObject().openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        return user;
    }

}
