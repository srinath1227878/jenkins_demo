package in.sp.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.sp.main.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String username);
}
