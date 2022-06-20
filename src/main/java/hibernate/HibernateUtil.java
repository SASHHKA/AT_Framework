package hibernate;

import entity.LoginData;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory==null) {
            sessionFactory=initSessionFactory();
        }
        return sessionFactory;
    }

    private static SessionFactory initSessionFactory() {
        Configuration configuration = new Configuration();
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("src/main/resources/config.properties"));
            configuration.setProperties(props);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // Adding classes to Hibernate
        configuration.addAnnotatedClass(LoginData.class);


        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
