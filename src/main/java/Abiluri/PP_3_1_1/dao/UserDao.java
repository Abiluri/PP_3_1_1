package Abiluri.PP_3_1_1.dao;


import Abiluri.PP_3_1_1.model.User;

import java.util.List;

public interface UserDao {
    void insertUser(String name, String email, String password);
    void updateUser(Long id, String name, String email, String password);
    void deleteUser(String email);
    List<User> getUsers();
    User getUserByID(Long id);
}