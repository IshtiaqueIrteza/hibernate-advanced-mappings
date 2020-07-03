package com.hibernate.demo;

import com.hibernate.demo.model.Instructor;
import com.hibernate.demo.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Ishtiaque on 6/24/2020.
 */
public class HibernateAdvancedMappingsDemoApp {

    public static void main(String args[]){

        //one to one, {uni, bi}

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session;

        try {

            //uni - directional

            //save

            /*session = factory.getCurrentSession();
            session.beginTransaction();

            Instructor tmpInstructor = new Instructor();
            tmpInstructor.setFirstName("Apache");
            tmpInstructor.setLastName("Mvn");
            tmpInstructor.setEmail("mvn@luv2code.com");

            InstructorDetail tmpInsDtl = new InstructorDetail();
            tmpInsDtl.setYoutubeChannel("www.youtube.com/derby");
            tmpInsDtl.setHobby("Football");

            tmpInstructor.setInstructorDetail(tmpInsDtl);

            session.save(tmpInstructor);

            session.getTransaction().commit();*/

            //delete

            /*session = factory.getCurrentSession();

            session.beginTransaction();

            Instructor fetchedInstructor = session.get(Instructor.class, 1L);

            session.delete(fetchedInstructor);

            session.getTransaction().commit();*/

            //bi-directional

            //save

            /*session = factory.getCurrentSession();

            session.beginTransaction();

            InstructorDetail insDtl = new InstructorDetail();
            insDtl.setYoutubeChannel("www.youtube.com/guitar");
            insDtl.setHobby("Guitar");

            Instructor ins = new Instructor();
            ins.setFirstName("tstUsr");
            ins.setLastName("tst");
            ins.setEmail("test@gmail.com");

            insDtl.setInstructor(ins);

            ins.setInstructorDetail(insDtl);

            session.save(insDtl);

            session.getTransaction().commit();*/

            //fetch and delete

            /*session = factory.getCurrentSession();

            session.beginTransaction();

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3L);

            //delete

            session.delete(instructorDetail);

            session.getTransaction().commit();*/
        }
        catch (Exception ex){
            //
        }
        finally {
            factory.close();
        }
    }
}
