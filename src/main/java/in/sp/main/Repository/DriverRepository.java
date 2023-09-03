package in.sp.main.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.Entity.Driver;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{

}
