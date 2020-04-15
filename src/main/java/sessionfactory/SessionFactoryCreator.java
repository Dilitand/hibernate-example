package sessionfactory;

import models.Account;
import models.Accountop;
import models.Personx;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionFactoryCreator {

    private static SessionFactory sessionFactory = null;

    private SessionFactoryCreator() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new org.hibernate.cfg.Configuration().configure();
            configuration.addAnnotatedClass(Personx.class);
            configuration.addAnnotatedClass(Account.class);
            configuration.addAnnotatedClass(Accountop.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
