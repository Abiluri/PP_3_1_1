package Abiluri.PP_3_1_1.service;

import Abiluri.PP_3_1_1.model.User;
import java.util.List;


public interface UserService {
    public void insertUser(User user);
    public void deleteUser(Long id);
    public List<User> getAllUsers();
    public User getUserById(Long id);
}