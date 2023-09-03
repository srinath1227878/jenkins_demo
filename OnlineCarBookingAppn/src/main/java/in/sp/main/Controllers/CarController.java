package in.sp.main.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.Entity.Car;
import in.sp.main.Repository.CarRepository;
import in.sp.main.Services.CarService;
import in.sp.main.Services.UserService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	CarService carService;
	
	
	@PostMapping("/insert")
	public String insertingCarInfo(@RequestBody Car car) {
	
		return carService.insertCarInfo(car);
		
	}
	
	
	@GetMapping("/listOfCars")
	public List<Car> carInfo(){
		return carService.carDetails();
	}
	//car specification by its id
	
	@GetMapping("/carDetails/{id1}")
	public Car findCar(@PathVariable("id1") int id) {
		return carService.findCar(id);
	}

}
