package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
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
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public List<User> findCar(String model, int series) {
        List<Car> carQuery = sessionFactory.getCurrentSession().createQuery(("from Car where model = '" + model + "' and series = '" + series + "'"))
                .getResultList();
        List<User> owners = new ArrayList<>();
        for (Car car : carQuery) {
            owners.add(car.getUser());
        }
        return owners;
    }
}