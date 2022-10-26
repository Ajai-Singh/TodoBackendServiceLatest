package com.example.demo.controller.DAOs;

import com.example.demo.controller.Models.Subject;
import com.example.demo.controller.Repos.CustomSubjectRepo;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class SubjectDaoImpl implements CustomSubjectRepo {
    Configuration config = new Configuration();
    SessionFactory sessionFactory = config.configure().buildSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    Transaction transaction = session.beginTransaction();

    @Override
    public Subject findSubjectByClassName(String className) {
        Subject subject;
        try {
            Query query = session.createQuery("FROM Subject s WHERE s.subjectName=:className");
            query.setParameter("className", className);
            subject = (Subject) query.getSingleResult();
        } catch(NoResultException nre) {
            return null;
        }
        return subject;
    }
}
