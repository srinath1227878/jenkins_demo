package in.sp.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.sp.main.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmailAndPassword(String email,String password);
	

}
