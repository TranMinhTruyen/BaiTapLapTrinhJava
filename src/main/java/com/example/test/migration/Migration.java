package com.example.test.migration;

import org.hibernate.Session;

public class Migration {
    public static void main(String[] args) {
        try (Session session = HibernateUlti.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.getTransaction().commit();
        }
    }
}
