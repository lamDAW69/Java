package org.example.dao;
import org.example.entities.User;

import java.util.List;

public interface UserDAO {

    public List<User> getUsers();
    public int insertUser(User user);
    public void deleteUser(int id);
    public void updateUser(User user);
}
