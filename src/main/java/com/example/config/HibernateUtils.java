package com.example.config;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@org.springframework.context.annotation.Configuration
public class HibernateUtils {
    private static final SessionFactory FACTORY;

    static{
        Configuration conf = new Configuration();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate-mysql.cfg.xml")
                .build();
        FACTORY = conf.buildSessionFactory(serviceRegistry);
    }
    public static SessionFactory getSessionFactory() {
        return FACTORY;
    }
}
