package peaksoft;

import jakarta.persistence.Query;
import org.hibernate.Session;
import peaksoft.entity.Student;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class App {
    public static void main( String[] args ) {
//        HibernateUtil.getSession();

        Student student = new Student("Alinay",  18);
        Student student1 = new Student("alika",  19);
        Student student2 = new Student("Malika",  17);
//        create(student);
//        create(student1);
//        create(student2);

//        System.out.println(getById(3));
//        System.out.println(read());
//        update(2, "Altynbek", 24);
//        delete(3);
        deleteAll();
    }

    public static void deleteAll() {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Student"); query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Student");
    }


    public static void delete(int id) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Student e = session.get(Student.class, id);
        session.delete(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + e);
    }


    public static void update(int id, String name, int age) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Student em = session.get(Student.class, id);
        em.setName(name);
        em.setAge(age);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated!");

    }

        public static List<Student> read() {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        List<Student> students = session.createQuery("FROM Student").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded " + students.size() + " student");
        return students;
    }

    public static int create(Student student) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("Added successfully " + student);
        return (int) student.getId();
    }

    public static Student getById(int id) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }
}
