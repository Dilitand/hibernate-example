package dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import sessionfactory.SessionFactoryCreator;

import java.util.List;

public class DaoImpl {

    SessionFactory sessionFactory;

    public DaoImpl(){
        sessionFactory = SessionFactoryCreator.getSessionFactory();
    }

    public void save(Object o){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(o);
        transaction.commit();
        session.close();
    }

    public void update(Object o){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(o);
        transaction.commit();
        session.close();
    }

    public List getListFromQuery (String query){
        List list = sessionFactory.openSession().createQuery(query).list();
        return list;
    }
}
