package Main;

import User.HibernateUtil;
import User.User;
import org.hibernate.Session;

/**
 * Created by Андрей on 08.05.2017.
 */
public class EnterPoint {

    public static void main(String[] args) {
        System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User user = new User(1, "admin", "admin", "andreyredkovskiy@mail.ru", 1, 1, 2);

        session.save(user);
        session.getTransaction().commit();
    }

}
