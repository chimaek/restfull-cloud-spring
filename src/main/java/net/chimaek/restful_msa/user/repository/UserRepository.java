package net.chimaek.restful_msa.user.repository;

import java.util.Optional;
import net.chimaek.restful_msa.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {






  Optional<User> findUserByNameAndPassword(String name, String password);
}
