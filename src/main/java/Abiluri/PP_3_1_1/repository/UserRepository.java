package Abiluri.PP_3_1_1.repository;

import Abiluri.PP_3_1_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends JpaRepository<User, Long> {
}
