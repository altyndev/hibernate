package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.security.auth.login.AppConfigurationEntry;

public class HibernateUtil {

    private static final SessionFactory session = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("hibernate.cfg.xml").addPackage("peaksoft").buildSessionFactory();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public static SessionFactory getSession() {
        return session;
    }

    public static void shutdown() {
        getSession().close();
    }
}
