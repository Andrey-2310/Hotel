package HibernateUtil;

/**
 * Created by Андрей on 08.05.2017.
 */

import EntityDB.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure("configs/Hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();

        } catch (HibernateException he) {
            System.out.println("Session Factory creation failure");
            throw he;
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Чистит кеш и закрывает соединение с БД
        getSessionFactory().close();
    }

    public static List getUsers(Session session) {
        Criteria c2 = session.createCriteria(User.class);
        c2.add(Restrictions.like("userID", 1));
        List suppliers = c2.list();
        for (Object s : suppliers) {
            System.out.println(s.toString());
        }
        return suppliers;
    }

    public static boolean checkNewUser(Session session, User user){
       if(!User.validateUser(user))return false;
        Criteria c1 = session.createCriteria(User.class);
        c1.add(Restrictions.like("login", user.getLogin()));
        List suppliers = c1.list();
        if(!suppliers.isEmpty()) return false;
        Criteria c2 = session.createCriteria(User.class);
        c2.add(Restrictions.like("password", user.encription(user.getPassword())));
        suppliers = c2.list();
        if(!suppliers.isEmpty()) return false;
        Criteria c3 = session.createCriteria(User.class);
        c3.add(Restrictions.like("email", user.getEmail()));
        suppliers = c3.list();
        if(!suppliers.isEmpty()) return false;
        return true;
    }

    public static boolean checkUser(Session session, User user) {
        Criteria c1 = session.createCriteria(User.class);
        c1.add(Restrictions.like("login", user.getLogin()));
        c1.add(Restrictions.like("password", user.encription(user.getPassword())));
        List suppliers = c1.list();
        System.out.println(user.encription(user.getPassword()));
        if(suppliers.isEmpty()) return false;
       /* Criteria c2 = session.createCriteria(User.class);
        c2.add(Restrictions.like("password", user.encription(user.getPassword())));
        suppliers = c2.list();
        if(!suppliers.isEmpty()) return false;*/
        return true;
    }


    public static void addUser(Session session, User user){
        session.save(user);
    }
}
