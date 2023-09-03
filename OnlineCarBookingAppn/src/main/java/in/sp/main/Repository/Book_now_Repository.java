package in.sp.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sp.main.Entity.Book_now;

@Repository
public interface Book_now_Repository extends JpaRepository<Book_now, Integer> {

}
