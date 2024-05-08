package com.tasksmng.taskmanagement.Utils;

import com.tasksmng.taskmanagement.model.Board;
import com.tasksmng.taskmanagement.model.Card;
import com.tasksmng.taskmanagement.model.Column;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;

public class HibernateSessionManager {

    public static SessionFactory getSessionFactory() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(dbSettings()).build();

        Metadata metadata = new MetadataSources(serviceRegistry).
                addAnnotatedClass(Board.class)
                .addAnnotatedClass(Column.class)
                .addAnnotatedClass(Card.class)
                .buildMetadata();

        return metadata.buildSessionFactory();
    }

    private static Map<String, Object> dbSettings() {
        Map<String, Object> settings = new HashMap<String, Object>();
        //Tutaj mozna dodac jakies ustawienia do hibernate

        return settings;
    }
}
