package in.sp.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.Entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{
	

}
