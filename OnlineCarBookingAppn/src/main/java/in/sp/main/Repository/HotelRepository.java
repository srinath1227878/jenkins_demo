package in.sp.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sp.main.Entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	

}
