package peaksoft;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import peaksoft.entity.Passport;
import peaksoft.entity.Person;

public class App {
    public static void main( String[] args ) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory();

//        Session session = null;
        try {
            Session session = factory.openSession();
            Person person = new Person("Kuba", "Tashkojoev", "altyn@gmail.com", 24);
           Passport passport = new Passport("5634556", "Kyrgyz", "M");
           passport.setPerson(person);
           person.setPassport(passport);
           session.beginTransaction();
            session.save(passport);
            session.getTransaction().commit();
            System.out.println("Accessfully added person " + person);
        } finally {
            factory.close();
        }
//        session = factory.openSession();
//        session.beginTransaction();
//        Person person = session.get(Person.class, 1);
//        System.out.println(person);
//        System.out.println(person.getPassport());
//        session.getTransaction().commit();

//        session = factory.openSession();
//        session.beginTransaction();
//        Person person = session.get(Person.class,1);
//        session.delete(person);
//        session.getTransaction().commit();

    }
}
