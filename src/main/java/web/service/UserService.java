package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    User getUser(long id);
    List<User> getAllUsers();
    void updateUser(User user, long id);
    void deleteUser(long id);
}
