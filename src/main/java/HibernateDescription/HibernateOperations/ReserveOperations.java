package HibernateDescription.HibernateOperations;

import EntityDB.Reserve;
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
public class ReserveOperations {

    private static final Logger log = Logger.getLogger(ReserveOperations.class);


    public static Vector<Reserve> getAllReserves(Session session) {
        Criteria criteria = session.createCriteria(Reserve.class)
                .add(Restrictions.gt("roomID", 0));
        List suppliers = criteria.list();
        for (Object s : suppliers) {
            System.out.println(s.toString());
        }
        log.info("Заказы извлечены из базы данных");
        Vector<Reserve> reserves= new Vector<Reserve>();
        for(Object sup:suppliers){
            reserves.add((Reserve)sup);
        }
        return reserves;
    }

   public static boolean reserveValidation(Reserve reserve, Session session){
       if(reserve.getStartDate().compareTo(reserve.getFinishDate())>0) {
           log.info("Arrive date is bigger than Departure date");
           return false;
       }
       Criteria c1 = session.createCriteria(Reserve.class);
       c1.add(Restrictions.like("roomSize", reserve.getRoomSize()));
       List suppliers = c1.list();
       if(suppliers.size()>10) {
           log.info("Sorry, there is no free room with such an amount of beds");
           return false;
       }
       log.info("Заказ успешно прошёл валидацию");
       return true;
   }

    public static void addReserve(Session session, Reserve reserve){
        Transaction tx1 = session.beginTransaction();
        session.save(reserve);
        tx1.commit();
        log.info("Новый заказ успешно добавлен");
    }
}
