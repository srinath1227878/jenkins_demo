package in.sp.main.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.Entity.Drivers;
import in.sp.main.Repository.DriverRepository;

@Service
public class DriverService {

	@Autowired
	DriverRepository driverRepository;
	
	public String driverData(Drivers drivers) {
		driverRepository.save(drivers);
		return "Driver information inserted successfully";
	}
	
	
	//for getting driver information
	public List<Drivers> driversInfo(){
		return driverRepository.findAll();
	}
	
}
