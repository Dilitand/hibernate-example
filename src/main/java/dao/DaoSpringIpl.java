package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// использование sessionFactory.getCurrentSession(); дает ошибку...
// Exception in thread "main" org.hibernate.HibernateException: Could not obtain transaction-synchronized Session for current thread

@Transactional
@Repository("daospring")
public class DaoSpringIpl implements Dao {


    private final SessionFactory sessionFactory;

    @Autowired
    DaoSpringIpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void save(Object o) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(o);
        transaction.commit();
        session.close();
    }

    public void update(Object o) {

    }

    public List getListFromQuery(String query) {
        List list = sessionFactory.openSession().createQuery(query).list();
        return list;
    }
}
