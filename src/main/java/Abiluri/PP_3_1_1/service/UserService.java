package Abiluri.PP_3_1_1.service;


import Abiluri.PP_3_1_1.model.User;

import java.util.List;

public interface UserService {
    void insertUser(String name, String email, String password);
    void updateUser(Long id, String name, String email, String password);
    void deleteUser(String email);
    List<User> getAllUsers();
    User getUserByID(Long id);
}
