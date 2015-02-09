package by.hryshyn.app.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * This file create, return and close the SessionFactory,
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Create the SessionFactory from hibernate.cfg.xml
     * @throws ExceptionInInitializerError
     * in case SessionFactory initialization is failed
     */
    private static SessionFactory buildSessionFactory() {
       try {
           return new AnnotationConfiguration().configure().buildSessionFactory();
       }
       catch (Throwable exception){
           System.err.println("Initial SessionFactory creation failed." + exception);
           throw new ExceptionInInitializerError(exception);
       }
    }

    /**
     * Return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Close SessionFactory
     */
    public static void shutdown(){
        getSessionFactory().close();
    }
}
