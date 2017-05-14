package HibernateDescription.HibernateOperations;

import EntityDB.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Андрей on 14.05.2017.
 */
public class UserOperations {

    private static final Logger log = Logger.getLogger(UserOperations.class);
  /*  public static List getUsers(Session session) {
        Criteria c2 = session.createCriteria(User.class);
        c2.add(Restrictions.like("userID", 1));
        List suppliers = c2.list();
        for (Object s : suppliers) {
            System.out.println(s.toString());
        }
        return suppliers;
    }*/

    public static boolean checkNewUser(Session session, User user) {
        if (!User.validateUser(user)) return false;
        Criteria c1 = session.createCriteria(User.class);
        c1.add(Restrictions.like("login", user.getLogin()));
        List suppliers = c1.list();
        if (!suppliers.isEmpty()) {
            log.info("Пользователь с выбранным логином существует");
            return false;}
        Criteria c2 = session.createCriteria(User.class);
        c2.add(Restrictions.like("password", user.encription(user.getPassword())));
        suppliers = c2.list();
        if (!suppliers.isEmpty()) {
            log.info("Пользователь с выбранным паролем существует");
            return false;
        }
        Criteria c3 = session.createCriteria(User.class);
        c3.add(Restrictions.like("email", user.getEmail()));
        suppliers = c3.list();
        if (!suppliers.isEmpty()) {
            log.info("Пользователь с выбранным электронным ящиком существует");
            return false;
        }
        return true;
    }

    public static boolean checkUser(Session session, User user) {
        User userDB = session.get(User.class, user.encription(user.getPassword()));
        if (userDB == null){
            log.info("Неверный пароль");
            return false;
        }
        user.setEmail(userDB.getEmail());
        return true;

    }


    public static void addUser(Session session, User user) {
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        log.info("Новый пользователь успешно добавлен");
    }
}
