package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    public List<User> listUsers();

    public List<User> getUserByCar(String model, Integer series);
}
