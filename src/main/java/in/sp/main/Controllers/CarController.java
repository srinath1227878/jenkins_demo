package in.sp.main.Controllers;

import java.util.List;

import in.sp.main.Dto.CarResponseDTO;
import in.sp.main.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.sp.main.Entity.Car;
import in.sp.main.Services.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	CarService carService;
	
	@PostMapping("/insert")
	public String insertingCarInfo(@RequestBody Car car)
	{
	
		return carService.insertCarInfo(car);
		
	}
	@GetMapping("/listOfCars")
	public List<CarResponseDTO> carInfo(){
		List<CarResponseDTO> carResponseDTOList = carService.carDetails(); //carResponseDTOList
		return carResponseDTOList;
	}

//		return carService.carDetails();
//	}
	//car specification by its id
	
	@GetMapping("/carDetails/{id1}")
	public Car findCar(@PathVariable("id1") int id)
	{
		return carService.findCar(id);
	}
}
