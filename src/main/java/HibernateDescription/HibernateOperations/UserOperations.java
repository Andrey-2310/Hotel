package HibernateDescription.HibernateOperations;

import EntityDB.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Vector;

/**
 * Created by Андрей on 14.05.2017.
 */
public class UserOperations {

    private static final Logger log = Logger.getLogger(UserOperations.class);


    public static Vector getAllUsers(Session session) {
        Criteria criteria = session.createCriteria(User.class)
                .add(Restrictions.gt("userID", 0));
        List suppliers = criteria.list();
        for (Object s : suppliers) {
            System.out.println(s.toString());
        }
        log.info("Пользователи извлечены из базы данных");
        Vector<User> users= new Vector<User>();
        for(Object sup:suppliers){
            users.add((User)sup);
        }
        return users;
    }

    public static boolean checkNewUser(Session session, User user) {
        if (!User.validateUser(user)) return false;
        Criteria c1 = session.createCriteria(User.class);
        c1.add(Restrictions.like("login", user.getLogin()));
        List suppliers = c1.list();
        if (!suppliers.isEmpty()) {
            log.info("Пользователь с выбранным логином существует");
            return false;}
        Criteria c2 = session.createCriteria(User.class);
        c2.add(Restrictions.like("password",user.getPassword()));
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
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.like("password",user.getPassword()));
        criteria.add(Restrictions.like("login",user.getLogin()));
        List suppliers = criteria.list();
        if (suppliers.isEmpty()) {
            log.info("Неверный пароль");
            return false;
        }
        User userDB=(User)suppliers.get(0);
        user.setEmail(userDB.getEmail());
        user.setUserID(userDB.getUserID());
        return true;

    }


    public static void addUser(Session session, User user) {
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        log.info("Новый пользователь успешно добавлен");
    }

    public static boolean checkAdmin(User user) {

        System.out.println( user.toString());
       if(user.getLogin().equals("admin") && user.getPassword().equals(User.encription("admin"))) {
           log.info("Пользователь является администратором");
           return true;
       }
        log.info("Пользователь не является администратором");
        return false;
    }
}
