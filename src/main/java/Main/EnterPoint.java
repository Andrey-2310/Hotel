package Main;

import EntityDB.User;
import HibernateUtil.UserHibernateUtil;
import org.hibernate.Session;

/**
 * Created by Андрей on 08.05.2017.
 */

public class EnterPoint {

    public static void main(String[] args) {
        Session session = UserHibernateUtil.getSessionFactory().openSession();
        /*session.beginTransaction();
        UserHibernateUtil.getUsers(session);
    */
        User user = new User("user4", "user4");
     /*   if (UserHibernateUtil.checkNewUser(session, user))
            System.out.println("Vse ogon' ");
        else System.out.println("ne och");*/
        if (UserHibernateUtil.checkUser(session, user))
            System.out.println("Vse ogon' ");
        else System.out.println("ne och");

        //  User user = new User("user7", "user7", "niggas@mail.ru");
        //  user.setUserID(8);
        //  session.save(user);
        // session.load


     /*  Criteria c2 = session.createCriteria(User.class);
        c2.add(Restrictions.like("userID", 1));
        List suppliers=c2.list();
        for(Object s: suppliers){
            System.out.println(s.toString());
        }
*/
        //     session.getTransaction().commit();
        //  session.find()
    }

}
