package in.sp.main.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.Entity.Drivers;
import in.sp.main.Services.DriverService;

@RequestMapping("/Drivers")
@RestController
public class DriverController {
	
	@Autowired
	DriverService driverService;
	
	@PostMapping("/insertDriverData")
	public String insertingDriverData(@RequestBody Drivers drivers) {
		return driverService.driverData(drivers);
		
	}
	
	
	@GetMapping("/DriverList")
	public List<Drivers> listOfDrivers(){
		return driverService.driversInfo();
	}

}
