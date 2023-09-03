package in.sp.main.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.Entity.Drivers;

public interface DriverRepository extends JpaRepository<Drivers, Integer>{

}
