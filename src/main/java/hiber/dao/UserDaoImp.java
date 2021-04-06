package hiber.dao;

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
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUser(String model, int series) {
        Session session = sessionFactory.getCurrentSession();
        String HQL = "FROM User user WHERE car.model=:carModel AND car.series=:carSeries";
        Query query = session.createQuery(HQL, User.class);
        query.setParameter("carModel", "car_user1");
        query.setParameter("carSeries", 1);
        List<User> list = query.getResultList();
        return list.get(0);
    }
}
