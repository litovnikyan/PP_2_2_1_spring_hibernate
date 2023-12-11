package hiber.dao;

import hiber.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserDao {
   public void add(User user);

   public List<User> listUsers();

   public List<User> getUserByCar(String model, Integer series);
}
