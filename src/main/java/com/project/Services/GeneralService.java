package com.project.Services;


import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralService {

    private final SessionFactory sessionFactory;

    @Autowired
    public GeneralService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional
    public <T> List<T> getList(Class<T> clazz) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM " + clazz.getSimpleName();
        return session.createQuery(hql, clazz).getResultList();
    }



}