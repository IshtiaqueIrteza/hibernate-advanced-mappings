package com.hibernate.demo;

import com.hibernate.demo.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


/**
 * Created by Ishtiaque on 6/22/2020.
 */
public class HibernateDemoApplication {

    public static void main(String args[]){

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session;

        try {

            //create

            /*session = factory.getCurrentSession();

            session.beginTransaction();

            Student s = new Student("Akash12","Islam", "akash12@gmail.com");

            session.save(s);

            session.getTransaction().commit();*/

            //read

            /*session = factory.getCurrentSession();

            session.beginTransaction();

            Student insertedStudent = session.get(Student.class, s.getId());

            session.getTransaction().commit();*/

            //query

            /*session = factory.getCurrentSession();

            session.beginTransaction();

            List<Student> lst = session.createQuery("from Student").getResultList();
            List<Student> lst1 = session.createQuery
                    ("from Student s where s.lastName = 'Islam'").getResultList();
            List<Student> lst2 = session.createQuery
                    ("from Student s where s.lastName = 'Islam' or s.firstName = 'Akash'")
                    .getResultList();
            List<Student> lst3 = session.createQuery
                    ("from Student s where s.email like '%gmail.com'").getResultList();

            session.getTransaction().commit();*/

            //update

            /*session = factory.getCurrentSession();

            session.beginTransaction();

            Student tmpStudent = session.get(Student.class, 10L);
            tmpStudent.setEmail("testUpdate@yahoo.com");

            session.getTransaction().commit();*/

            //update query

            /*session = factory.getCurrentSession();

            session.beginTransaction();

            int res = session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();


            session.getTransaction().commit();*/

            //delete

            /*session = factory.getCurrentSession();

            session.beginTransaction();

            Student studentToDlt = session.get(Student.class, 4L);

            session.delete(studentToDlt);

            session.getTransaction().commit();*/

            //delete query

            /*session = factory.getCurrentSession();

            session.beginTransaction();

            int dltRes = session.createQuery("delete from Student where id = 6").executeUpdate();

            session.getTransaction().commit();*/

            //Open Session test

            session = factory.openSession();

//            session.beginTransaction();

            List<Student> studentList = session.createQuery("from Student").getResultList();

//            studentList.get(0).setEmail("changed");

//            session.getTransaction().commit();

            /*Student tst = new Student("tst", "tst", "tst");

            session.save(tst);*/

            studentList = session.createQuery("from Student").getResultList();

            session.beginTransaction();

            session.createQuery("update Student set firstName = 'frank' where id = :id")
                    .setParameter("id", 9L).executeUpdate();

            session.getTransaction().commit();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }
}
