package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void updateUser(User user, long id) {
        User userUpdate = entityManager.find(User.class, id);
        userUpdate.setName(user.getName());
        userUpdate.setLastname(user.getLastname());
    }

    @Override
    public void deleteUser(long id) {
        User userDelete = entityManager.find(User.class, id);
        entityManager.remove(userDelete);
    }
}
