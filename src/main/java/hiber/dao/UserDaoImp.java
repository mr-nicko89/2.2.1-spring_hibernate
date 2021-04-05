package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);

   }

   @Override
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUser(String model, int series) {
/*//Без HQL:
      User user = null;
      Session session = sessionFactory.getCurrentSession();
      user = session.get(User.class,1L);*/
      Session session = sessionFactory.getCurrentSession();
      String HQL="FROM User user LEFT JOIN FETCH user.car WHERE car.model=:carModel";
      Query query = session.createQuery(HQL, User.class);
      query.setParameter("carModel",1);
      User user = query.uni;
      System.out.println(user);
//      Car car = user.getCar();
//      System.out.println(car);
      return null;
   }
}
