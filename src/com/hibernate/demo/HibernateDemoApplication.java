package com.hibernate.demo;

import com.hibernate.demo.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Ishtiaque on 6/22/2020.
 */
public class HibernateDemoApplication {

    public static void main(String args[]){

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Student s = new Student("Akash","Islam", "akash@gmail.com");

            session.beginTransaction();

            session.save(s);

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
