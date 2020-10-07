package models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;


public class SessionUtils {
    private static SessionUtils instance;
    private SessionFactory sessionFactory;
    public static SessionUtils getInstance() { return instance;}
    public SessionUtils() {
        instance=new SessionUtils();
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory=configuration.buildSessionFactory();
    }
    public Session getSession() { return getInstance().sessionFactory.openSession();}
}
