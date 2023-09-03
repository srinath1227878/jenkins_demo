package in.sp.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sp.main.Entity.Atmpage;

import java.util.List;
import java.util.Optional;


public interface AtmRepository extends JpaRepository<Atmpage, Integer> {
List<Atmpage> findByEmail(String email);

}
