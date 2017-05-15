package Main;

import EntityDB.User;
import HibernateDescription.HibernateOperations.UserOperations;

/**
 * Created by Андрей on 08.05.2017.
 */

public class EnterPoint {

    public static void main(String[] args) {

User user=new User("admin", "admin");
       // Session session = HibernateUtil.getSessionFactory().openSession();
        UserOperations.checkAdmin( user);


      //  UserOperations.addUser(session, new User("a", "A", "B"));
        /*session.beginTransaction();
        HibernateUtil.getUsers(session);
    */


      /*  if (UserOperations.checkUser(session, user))
            System.out.println("Vse ogon' ");
        else System.out.println("ne och");
*/
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
