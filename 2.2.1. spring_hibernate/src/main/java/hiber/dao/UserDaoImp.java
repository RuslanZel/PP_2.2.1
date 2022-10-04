package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository

public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByCar(String model, int series) {
        String userByCar = "from User as u where u.carsId.model = :model and u.carsId.series = :series";
        TypedQuery<User> queryUserByCar = sessionFactory.getCurrentSession().createQuery(userByCar, User.class);
        queryUserByCar.setParameter("model", model);
        queryUserByCar.setParameter("series", series);
        return queryUserByCar.getSingleResult();
    }
}
