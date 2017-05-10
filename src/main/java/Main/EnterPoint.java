package Main;

import EntityDB.User;
import org.hibernate.Session;

/**
 * Created by Андрей on 08.05.2017.
 */

public class EnterPoint {

    public static void main(String[] args) {
        Session session = User.UserHibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        User user = new User("user7", "user7", "niggas@mail.ru", 7, 12, 24);
      //  user.setUserID(8);
        session.save(user);
       // session.load

    /*    Criteria c2 = session.createCriteria(User.class);
        c2.add(Restrictions.like("userID", 1));
        List suppliers=c2.list();
        for(Object s: suppliers){
            System.out.println(s.toString());
        }
    */
        session.getTransaction().commit();
        //  session.find()
    }

}
